package dados;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class PrintBD {

	public static void main(String[] args)
	{
		DatabaseConnectionSingleton pool = DatabaseConnectionSingleton.getInstance();
		
		pool.printTableSolicitacaoMuseu();
	}

}
