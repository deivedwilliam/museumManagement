package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.DatabaseConnectionSingleton;
import dados.DTO.*;
public class GestorFinder {
	private Connection dbConn;

	private PreparedStatement findByCpfStmt;
	public GestorFinder() throws SQLException{
		this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();

        this.findByCpfStmt = dbConn.prepareStatement(
                "SELECT Usuario.id, nome, cpf, senha, Gestor.idMuseu FROM Usuario INNER JOIN Funcionario ON Usuario.id = Funcionario.id INNER JOIN Gestor ON Funcionario.id = Gestor.id WHERE CPF = ?"
        );        
	}
	public GestorDTO search(String CPF) throws SQLException {
		findByCpfStmt.clearParameters();

        findByCpfStmt.setString(1, CPF);

        ResultSet rs = findByCpfStmt.executeQuery();
        if(rs.next()) {
        	GestorDTO retorno = new GestorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        	retorno.setIdMuseu(rs.getInt(5));
        	return retorno;
        }
        
		return null;
	}
	
}
