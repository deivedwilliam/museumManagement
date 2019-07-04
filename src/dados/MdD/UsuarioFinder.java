package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.DatabaseConnectionSingleton;
import dados.DTO.AdministradorDTO;
import dados.DTO.GestorDTO;
import dados.DTO.Usuario;
import dados.DTO.VisitanteDTO;

public class UsuarioFinder {
	private Connection dbConn;
	private PreparedStatement findByCpfStmt;
	
	
	public UsuarioFinder() throws SQLException{
		this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();

        this.findByCpfStmt = dbConn.prepareStatement(
                "SELECT id, nome, cpf, senha, tipo FROM Usuario WHERE CPF = ?"
        );        
	}
	
	
	public Usuario search(String CPF) throws SQLException {
		findByCpfStmt.clearParameters();

        findByCpfStmt.setString(1, CPF);

        ResultSet rs = findByCpfStmt.executeQuery();
        if(rs.next()) {
        	Usuario retorno = null;
        	switch(rs.getString(5)) {
        		case "ADMINISTRADOR":
        			retorno = new AdministradorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        			break;
        		case "VISITANTE":
        			retorno = new VisitanteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        			break;
        	}
        	return retorno;
        }
        
        this.dbConn.close();
        
		return null;
	}
}
