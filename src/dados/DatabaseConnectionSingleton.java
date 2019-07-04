package dados;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.derby.iapi.sql.ResultSet;
import org.apache.derby.jdbc.EmbeddedDriver;


import java.sql.PreparedStatement;

@SuppressWarnings("unused")
public class DatabaseConnectionSingleton 
{
	private static final String DRIVE = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBCURL = "jdbc:derby:/home/deived/MyDB;create=true;user=teste;password=1234";
    private static DatabaseConnectionSingleton instance = new DatabaseConnectionSingleton();

    @SuppressWarnings("deprecation")
	private DatabaseConnectionSingleton()
    {
        try
        {
            Class.forName(DRIVE).newInstance();
        }
        catch(Exception e)
        {
            throw new RuntimeException("failed to initialize derby");
        }
    }

    public static DatabaseConnectionSingleton getInstance()
    {
    	
        return instance;
    }

    public Connection getConnection()
    {
        
        try
        {
            return DriverManager.getConnection(JDBCURL);
        }catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() 
    {
        try
        {
            DriverManager.getConnection(JDBCURL);
        }
        catch(SQLException ex)
        {
        
        }

    }
    
    public void createDataset() throws SQLException
    {
    	String[] dbScript = { 
    			"CREATE TABLE Usuario(\r\n"+
    			"id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n" +
    			"nome VARCHAR(100) NOT NULL,\r\n"+
    			"cpf VARCHAR(11) NOT NULL,\r\n"+
    			"senha VARCHAR(100) NOT NULL,\r\n"+
    			"tipo VARCHAR(13) NOT NULL\r\n"+
    			")", 
    			
    			"CREATE TABLE Museu(\r\n"	+
    			"id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n" +
    	    	"nome VARCHAR(100) NOT NULL,\r\n"	+
    			"dataCriacao DATE NOT NULL,\r\n"	+
    	    	"cidade VARCHAR(100) NOT NULL,\r\n" +
    			"estado VARCHAR(100) NOT NULL,\r\n"	+
    	    	"idGestor INTEGER NOT NULL,\r\n"	+
    			"CONSTRAINT fk_gestor FOREIGN KEY (idGestor) REFERENCES Usuario(id)\r\n"	+
    			")",
    			
    			"CREATE TABLE SolicitacaoMuseu(\r\n"+
				"id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n" +
    	    	"nome VARCHAR(100) NOT NULL,\r\n"+
    			"dataCriacao DATE NOT NULL,\r\n"+
    	    	"cidade VARCHAR(100) NOT NULL,\r\n"+
    			"estado VARCHAR(100) NOT NULL,\r\n"+
    	    	"cpfGestor VARCHAR(11) NOT NULL,\r\n"+
    	    	"senhaGestor VARCHAR(100) NOT NULL,\r\n" +
    	    	"nomeGestor VARCHAR(100) NOT NULL\r\n" +
    			")"
    			
    	};
    	
    	Connection con = null;
	    for (String sql : dbScript) {
	    	con = getConnection();
	    	System.out.println(sql);
	    	PreparedStatement s = con.prepareStatement(sql);
			s.executeUpdate();
	    }
	    if (con != null)
	    	con.close();
    
    }
    
	public void dropDataset() 
	{
		String[] dbScript = { "DROP TABLE Museu", "DROP TABLE Usuario", "DROP TABLE SolicitacaoMuseu"};
	    
    	Connection con = null;
    	
		for(String sql : dbScript)
		{
			try
			{
				con = this.getConnection();
		    	PreparedStatement s = con.prepareStatement(sql);
				s.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	    }
		
	    if(con != null)
	    {
			try
	    	{
				con.close();
			}
		    catch(SQLException e)
			{
		    	
			}
	    }
	}

	public void printTableSolicitacaoMuseu()
	{
		Connection con = null;
		
		String sql = "SELECT id, nome, dataCriacao, cidade, estado, cpfGestor, senhaGestor FROM SolicitacaoMuseu";		
		try
		{
			con = this.getConnection();
	    	PreparedStatement s = con.prepareStatement(sql);
			java.sql.ResultSet r =  s.executeQuery();
			
			while(r.next())
			{
				int id  = r.getInt(1);
				String nome = r.getString(2);
				String dataCriacao = r.getString(3);
				String cidade = r.getString(4);
				String estado = r.getString(5);
				String cpfGestor = r.getString(6);
				String senhaGestor = r.getString(7);
				System.out.println("id: " + id + " " + nome + " " + dataCriacao + " " + " " + cidade + " " + estado +" "+ cpfGestor +" "+ senhaGestor);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
   
	
		if(con != null)
		{
			try
			{
				con.close();
			}
		    catch(SQLException e)
			{
		    	
			}
		}
	}

    
    public static void main(String[] args)
    {
		DatabaseConnectionSingleton pool = DatabaseConnectionSingleton.getInstance();
		
		
		pool.dropDataset();
		
		try 
		{
			pool.createDataset();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}