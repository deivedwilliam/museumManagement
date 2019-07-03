package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dados.DatabaseConnectionSingleton;
import dados.DTO.SolicitacaoMuseuDTO;

public class SolicitacaoMuseuFinder {
	private Connection dbConn;

	private PreparedStatement findByIDStmt;
	public SolicitacaoMuseuFinder() throws SQLException{
		this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();
		this.findByIDStmt = dbConn.prepareStatement(
                "SELECT id, nome, dataCriacao, cidade, estado, cpfGestor, senhaGestor FROM Solicitacao WHERE id = ?");
	}
	public SolicitacaoMuseuDTO search(int Id) throws SQLException {
		this.findByIDStmt.clearParameters();
		this.findByIDStmt.setInt(1, Id);
		
		ResultSet rs = this.findByIDStmt.executeQuery();
		if(rs.next()) {
			SolicitacaoMuseuDTO solicitacao = new SolicitacaoMuseuDTO(
					rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			return solicitacao;
		}
		return null;
	}
}
