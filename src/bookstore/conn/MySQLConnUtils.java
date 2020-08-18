package bookstore.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	
	// Connect to MySQL
	public static Connection getMySQLConnection()
			throws ClassNotFoundException, SQLException{
		
		String hostName = "localhost";
		String dbName = "bookstore";
		String userName = "root";
		String password = "19950817";
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	
	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(connectionURL, userName, password);
		}
		catch(Exception e) {
			System.out.println("Didn't connect!");
			System.out.println(e);
		}
		
		return conn;
	}
}
