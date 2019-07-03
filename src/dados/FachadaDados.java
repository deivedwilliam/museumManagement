package dados;

import dados.DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.exception.*;

public abstract class FachadaDados 
{
	public abstract Usuario buscaUsuarioDTO(String cpf) throws UsuarioNaoExiste;
	public abstract boolean inserirUsuarioDTO(Usuario usuario) throws UsuarioJaExiste;

	public static FachadaDados getMock() 
	{	
		class MockFachada extends FachadaDados
		{

			@Override
			public Usuario buscaUsuarioDTO(String cpf) throws UsuarioNaoExiste
			{
				String query = "SELECT id ,nome,senha,tipo FROM Usuario";
				Connection con;
				DatabaseConnectionSingleton bd = DatabaseConnectionSingleton.getInstance();	
				try
				{
					con = bd.getConnection();
					PreparedStatement s = con.prepareStatement(query);
					s.setString(1, cpf);
					ResultSet rs = s.executeQuery();
					
					if(rs.next())
					{
						int id = rs.getInt(1);
						String nome = rs.getString(2);
						String senha = rs.getString(3);
						String tipo = rs.getString(4);
						con.close();
						switch(tipo)
						{
							case "ADMINISTRADOR":
								return new AdministradorDTO(id,nome,cpf,senha);
							case "VISITANTE":
								return new VisitanteDTO(id,nome,cpf,senha);
							case "FUNCIONARIO":
								return new GestorDTO(id,nome,cpf,senha);
							default:
								return null;
						}
						
					}
					else
					{
						con.close();
						return null;
					}			
				}
				catch(SQLException e)
				{
					System.out.println(e);
					return null;
				}
			}
			

			@Override
			public boolean inserirUsuarioDTO(Usuario usuario) throws UsuarioJaExiste 
			{
				DatabaseConnectionSingleton bd = DatabaseConnectionSingleton.getInstance();	
				Connection con;
				try 
				{
					con = bd.getConnection();
					PreparedStatement s = con.prepareStatement("INSERT nome,cpf,senha, tipo INTO Usuario values (?,?,?,?); ");
					s.setString(1, usuario.getNome());
					s.setString(2, usuario.getCPF());
					s.setString(3, usuario.getSenha());
					s.setString(4,usuario.getTipo().toString());
					s.executeUpdate();
					
					bd.shutdown();
					
					return true;
					
				}
				catch(SQLException e)
				{
					return false;
				}	
			}
		}
		
		return new MockFachada();
	}
}
