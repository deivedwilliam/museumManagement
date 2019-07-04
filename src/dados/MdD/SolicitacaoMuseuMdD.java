package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dados.DatabaseConnectionSingleton;
import dados.DTO.SolicitacaoMuseuDTO;;

public class SolicitacaoMuseuMdD implements IMapeadordeDados<SolicitacaoMuseuDTO> {
	private Connection dbConn;
	private PreparedStatement insertStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement deleteStmt;
    
    public SolicitacaoMuseuMdD() throws SQLException{
    	this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();  
    	this.insertStmt = dbConn.prepareStatement(
    			"INSERT INTO SolicitacaoMuseu(id, nome, dataCriacao, cidade, estado, cpfGestor, senhaGestor, nomeGestor) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)", 
    			PreparedStatement.RETURN_GENERATED_KEYS);
//    	this.updateStmt = dbConn.prepareStatement(
//    			"UPDATE SolicitacaoMuseu SET nome = ?, cidade = ?, estado = ?, dataCriacao = ?, cpfGestor = ?, senhaGestor = ? WHERE id = ?");
    	
    	this.deleteStmt = dbConn.prepareStatement("DELETE FROM SolicitacaoMuseu WHERE id = ? ");
    }
    
	@Override
	public void set(SolicitacaoMuseuDTO obj) throws SQLException {
		
		this.insertStmt.clearParameters();
		this.insertStmt.setString(1, obj.getNome());
		this.insertStmt.setString(2, obj.getDataCriacao());
		this.insertStmt.setString(3, obj.getCidade());
		this.insertStmt.setString(4, obj.getEstado());
		this.insertStmt.setString(5, obj.getCpfGestor());
		this.insertStmt.setString(6, obj.getSenhaGestor());
		this.insertStmt.setString(7, obj.getNomeGestor());
		
		
		this.deleteStmt.clearParameters();
		this.deleteStmt.setInt(1, obj.getId());
		
//		this.updateStmt.clearParameters();
//		this.updateStmt.setString(1, obj.getNome());
//		this.updateStmt.setString(2, obj.getCidade());
//		this.updateStmt.setString(3, obj.getDataCriacao());
//		this.updateStmt.setString(4, obj.getCpfGestor());
//		this.updateStmt.setString(5, obj.getSenhaGestor());
//		this.updateStmt.setInt(6, obj.getId());
//		
	}

	@Override
	public void insert() throws SQLException {
		this.insertStmt.executeUpdate();
	}

	@Override
	public void delete() throws SQLException {
		this.deleteStmt.executeUpdate();
		
	}

	@Override
	public void update() throws SQLException {
		this.updateStmt.executeUpdate();
	}

}
