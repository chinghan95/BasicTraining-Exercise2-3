package bookstore.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getMyConnection()
			throws ClassNotFoundException, SQLException {
		return MySQLConnUtils.getMySQLConnection();
	}

}
