import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	public Connection getConnection() throws Exception {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","");
		return con;
		
	}

}