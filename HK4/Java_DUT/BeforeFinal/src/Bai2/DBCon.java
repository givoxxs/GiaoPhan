// Connect Database
package Bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static Connection conn = null;
	
	private static String url = "jdbc:mysql://localhost:3306/java_final_exam";
	private static String user = "root";
	private static String password = "";
	
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
