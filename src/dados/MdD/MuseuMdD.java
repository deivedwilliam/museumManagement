package dados.MdD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dados.DatabaseConnectionSingleton;
import dados.DTO.MuseuDTO;

public class MuseuMdD implements IMapeadordeDados<MuseuDTO> {
	private MuseuDTO m;
	private Connection dbConn;
	private PreparedStatement insertMuseuStmt;
    private PreparedStatement updateMuseuStmt;
    
    public MuseuMdD() throws SQLException{
    	this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();  
    	this.insertMuseuStmt = dbConn.prepareStatement(
    			"INSERT INTO Museu (id, nome, cidade, estado, dataCriacao, idGestor) VALUES (DEFAULT, ?, ?, ?, ?, ?)", 
    			PreparedStatement.RETURN_GENERATED_KEYS);
    	this.updateMuseuStmt = dbConn.prepareStatement(
    			"UPDATE Museu SET nome = ?, cidade = ?, estado = ?, dataCriacao = ?, idGestor = ? WHERE id = ?");
    }
    
	@Override
	public void set(MuseuDTO obj) throws SQLException {
		this.m = obj;
		
		this.insertMuseuStmt.clearParameters();
		this.insertMuseuStmt.setString(1, m.getNome());
		this.insertMuseuStmt.setString(2, m.getCidade());
		this.insertMuseuStmt.setString(3, m.getEstado());
		this.insertMuseuStmt.setDate(4, Date.valueOf(m.getDataCriacao()));
		this.insertMuseuStmt.setInt(5, m.getIdGestor());
		
		this.updateMuseuStmt.clearParameters();
		this.updateMuseuStmt.setString(1, m.getNome());
		this.updateMuseuStmt.setString(2, m.getCidade());
		this.updateMuseuStmt.setString(3, m.getEstado());
		this.updateMuseuStmt.setDate(4, Date.valueOf(m.getDataCriacao()));
		this.updateMuseuStmt.setInt(5, m.getIdGestor());
		this.updateMuseuStmt.setInt(6, m.getId());
	}

	@Override
	public void insert() throws SQLException {
		this.insertMuseuStmt.executeUpdate();
	}

	@Override
	public void delete() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws SQLException {
		this.updateMuseuStmt.executeUpdate();
	}

}
