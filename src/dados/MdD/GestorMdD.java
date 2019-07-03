package dados.MdD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.DatabaseConnectionSingleton;
import dados.DTO.GestorDTO;

public class GestorMdD implements IMapeadordeDados<GestorDTO> {
	private GestorDTO g;
	private Connection dbConn;
	private PreparedStatement insertUsuarioStmt;
    private PreparedStatement insertFuncionarioStmt;
    private PreparedStatement insertGestorStmt;
    private PreparedStatement updateUsuarioStmt;
    private PreparedStatement updateGestorStmt;
    
    public GestorMdD() throws SQLException{
    	this.dbConn = DatabaseConnectionSingleton.getInstance().getConnection();    	
		this.insertUsuarioStmt = dbConn.prepareStatement("INSERT INTO Usuario VALUES(DEFAULT, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
		this.insertFuncionarioStmt = dbConn.prepareStatement("INSERT INTO Funcionario VALUES(?)");
		this.insertGestorStmt = dbConn.prepareStatement("INSERT INTO Gestor VALUES(?, ?)");	
		this.updateUsuarioStmt = dbConn.prepareStatement("UPDATE Usuario SET nome = ?, cpf = ?, Senha = ?, tipo = ? WHERE id = ?");
		this.updateGestorStmt = dbConn.prepareStatement("UPDATE Gestor SET idMuseu = ? WHERE id = ?");
    }
    
	public void set(GestorDTO gestor) throws SQLException{
		this.g = gestor;
		insertUsuarioStmt.clearParameters();
		this.insertUsuarioStmt.setString(1, g.getNome());
		this.insertUsuarioStmt.setString(2, g.getCPF());
		this.insertUsuarioStmt.setString(3, g.getSenha());
		this.insertUsuarioStmt.setString(4, g.getTipo().toString());
		
		this.updateUsuarioStmt.setString(1, g.getNome());
		this.updateUsuarioStmt.setString(2, g.getCPF());
		this.updateUsuarioStmt.setString(3, g.getSenha());
		this.updateUsuarioStmt.setString(4, g.getTipo().toString());
		this.updateUsuarioStmt.setInt(5, g.getId());
		
		this.updateGestorStmt.setInt(1, g.getIdMuseu());
		this.updateGestorStmt.setInt(2, g.getId());
	}
	@Override
	public void insert() throws SQLException {
		insertUsuarioStmt.executeUpdate();

        ResultSet rs = insertUsuarioStmt.getGeneratedKeys();
        rs.next();
        int generatedId = rs.getInt(1);

        insertFuncionarioStmt.clearParameters();
        insertFuncionarioStmt.setInt(1, generatedId);
        insertFuncionarioStmt.executeUpdate();

        insertGestorStmt.clearParameters();
        insertGestorStmt.setInt(1, generatedId);
        insertGestorStmt.setInt(2, g.getIdMuseu());
        insertGestorStmt.executeUpdate();
	}

	@Override
	public void delete() throws SQLException{		
		//AQUI A COISA PODE FICAR MAIS COMPLICADA
	}

	@Override
	public void update() throws SQLException{
		updateUsuarioStmt.executeUpdate();
		updateGestorStmt.executeUpdate();
	}

}
