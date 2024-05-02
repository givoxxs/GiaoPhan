package me.hitoan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart", "root", "");
			System.out.println("Connected to the database");
		}
		return connection;
	}
	
//	public static void setConnection(Connection connection) {
//		DbCon.connection = connection;
//	}
//	
//	public static void closeConnection() {
//		try {
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
