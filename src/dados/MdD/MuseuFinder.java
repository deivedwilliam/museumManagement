package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import dados.DatabaseConnectionSingleton;
import dados.DTO.MuseuDTO;

public class MuseuFinder {
	private Connection dbConn;

	private PreparedStatement findByIDStmt;
	public MuseuFinder() throws SQLException{
		this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();
		this.findByIDStmt = dbConn.prepareStatement(
                "SELECT id, nome, dataCriacao, cidade, estado, idGestor FROM Museu WHERE id = ?");
	}
	public MuseuDTO search(int Id) throws SQLException {
		this.findByIDStmt.clearParameters();
		this.findByIDStmt.setInt(1, Id);
		
		ResultSet rs = this.findByIDStmt.executeQuery();
		if(rs.next()) {
			MuseuDTO museu = new MuseuDTO(
					rs.getInt(1), rs.getString(2),rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getInt(6));
			return museu;
		}
		return null;
	}
}
