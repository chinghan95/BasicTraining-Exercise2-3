package bookstore.conn;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bookstore.javabeans.*;

public class BookstoreDao {
	
	private static final String STORE_ID = "StoreID";
	private static final String NAME = "NAME";
	private static final String ADDRESS = "ADDRESS";
	private static final String TEL = "TEL";
	
//	private static Connection getConnection() {
//		Connection conn = null;
//		String hostName = "localhost";
//		String dbName = "bookstore";
//		String userName = "root";
//		String password = "19950817";
//		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?serverTimezone=UTC";
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(connectionURL, userName, password);
//		}
//		catch(Exception e) {
//			System.out.println("Didn't connect!");
//			System.out.println(e);
//		}
//		
//		return conn;
//	}

	public static int save(Bookstore bookstore) {
		int status = 0;
		try {
//			Connection connection = BookstoreDao.getConnection();
			Connection connection = ConnectionUtils.getMyConnection();
			String sql = "INSERT INTO Bookstore(Name, Address, Tel) VALUES(?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			// Set the values
			pstmt.setString(1, bookstore.getName());;
			pstmt.setString(2, bookstore.getAddress());
			pstmt.setString(3, bookstore.getTel());
			
			// Execute statement
			status = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	
	public static List<Bookstore> getAllBookstores(){
		// List to hold Bookstore objects
		List<Bookstore> listBookstore = new ArrayList<Bookstore>();
		
		try {
//			Connection connection = BookstoreDao.getConnection();
			Connection connection = ConnectionUtils.getMyConnection();
			String sql = "SELECT * FROM Bookstore";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				Bookstore bookstore = new Bookstore();
				
				int storeId = resultSet.getInt(STORE_ID);
				String name = resultSet.getString(NAME);		
				String address = resultSet.getString(ADDRESS);
				String tel = resultSet.getString(TEL);
				
				bookstore.setStoreId(storeId);
				bookstore.setName(name);
				bookstore.setAddress(address);
				bookstore.setTel(tel);
				
				listBookstore.add(bookstore);
			}
			pstmt.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listBookstore;
	}
	
	public static Bookstore getBookstoreById(int id) {
		Bookstore bookstore = null;
		
		try {
//			Connection connection = BookstoreDao.getConnection();
			Connection connection = ConnectionUtils.getMyConnection();
			String sql = "SELECT * FROM Bookstore where StoreId=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
		
				String name = resultSet.getString(NAME);		
				String address = resultSet.getString(ADDRESS);
				String tel = resultSet.getString(TEL);
				
				bookstore = new Bookstore(id, name, address, tel);
			}
			connection.close();		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bookstore;
	}
	
	public static int update(Bookstore bookstore) {
		int status = 0;
		try {
//			Connection connection = BookstoreDao.getConnection();
			Connection connection = ConnectionUtils.getMyConnection();
			String sql = "UPDATE Bookstore SET NAME=?, ADDRESS=?, TEL=? WHERE StoreID=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, bookstore.getName());
			pstmt.setString(2, bookstore.getAddress());
			pstmt.setString(3, bookstore.getTel());
			pstmt.setInt(4, bookstore.getStoreId());
			
			// Execute statement
			status = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int bookstoreId) {
		int status = 0;
		try {
//			Connection connection = BookstoreDao.getConnection();
			Connection connection = ConnectionUtils.getMyConnection();
			String sql = "DELETE FROM Bookstore where StoreId=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bookstoreId);
			
			// Execute statement
			status = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	

}
