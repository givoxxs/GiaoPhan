package hitoan.me.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getJDBCConnection() {
		Connection c = null;

		try {
			String url = "jdbc:mysql://localhost:3306/BANHANG";
			String username = "root";
			String password = "";
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
}
