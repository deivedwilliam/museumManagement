package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dados.DatabaseConnectionSingleton;
import dados.DTO.Usuario;

public class UsuarioMdD implements IMapeadordeDados<Usuario> 
{
	private Connection dbConn;
	private PreparedStatement insertStmt;
    private PreparedStatement updateStmt;
    
	public UsuarioMdD() throws SQLException{
		this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();
		this.insertStmt = dbConn.prepareStatement("INSERT INTO Usuario(id, nome, cpf, senha, tipo) VALUES(DEFAULT, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
		this.updateStmt = dbConn.prepareStatement("UPDATE Usuario SET nome = ?, cpf = ?, Senha = ?, tipo = ? WHERE id = ?");
	}

	@Override
	public void set(Usuario obj) throws SQLException {
		
		this.insertStmt.clearParameters();
		this.insertStmt.setString(1, obj.getNome());
		this.insertStmt.setString(2, obj.getCPF());
		this.insertStmt.setString(3, obj.getSenha());
		this.insertStmt.setString(4, obj.getTipo().toString());
		
		this.updateStmt.clearParameters();
		this.updateStmt.setString(1, obj.getNome());
		this.updateStmt.setString(2, obj.getCPF());
		this.updateStmt.setString(3, obj.getSenha());
		this.updateStmt.setString(4, obj.getTipo().toString());
		this.updateStmt.setInt(5, obj.getId());
		
	}

	@Override
	public void insert() throws SQLException {
		this.insertStmt.executeUpdate();
	}

	@Override
	public void delete() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws SQLException {
		this.updateStmt.executeUpdate();
	}

}
