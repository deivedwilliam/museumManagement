package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dados.DatabaseConnectionSingleton;
import dados.DTO.SolicitacaoMuseuDTO;

public class SolicitacaoMuseuFinder {
	private Connection dbConn;

	private PreparedStatement findByIDStmt;
	public SolicitacaoMuseuFinder() throws SQLException{
		this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();
		this.findByIDStmt = dbConn.prepareStatement(
                "SELECT id, nome, dataCriacao, cidade, estado, cpfGestor, senhaGestor, nomeGestor FROM SolicitacaoMuseu WHERE id = ?");
	}
	public SolicitacaoMuseuDTO search(int Id) throws SQLException {
		this.findByIDStmt.clearParameters();
		this.findByIDStmt.setInt(1, Id);
		
		ResultSet rs = this.findByIDStmt.executeQuery();
		
		if(rs.next())
		{
			SolicitacaoMuseuDTO solicitacao = new SolicitacaoMuseuDTO(
					rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			return solicitacao;
		}
		return null;
	}
	
	public ArrayList<SolicitacaoMuseuDTO> getMuseuSolicitacaoList() throws SQLException
	{
		ArrayList<SolicitacaoMuseuDTO> lst = new ArrayList<SolicitacaoMuseuDTO>();
		Statement stmt = dbConn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, nome, dataCriacao, cidade, estado, cpfGestor, senhaGestor, nomeGestor FROM SolicitacaoMuseu");
		while(rs.next()) {
			SolicitacaoMuseuDTO solicitacao = new SolicitacaoMuseuDTO(
					rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			lst.add(solicitacao);
		}

		if(this.dbConn != null)
		{
			this.dbConn.close();
		}
		
		return lst;
	}
}


