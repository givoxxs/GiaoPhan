package source_code;

import java.sql.*;

public class JDBCDemo {
	public static void main(String[] args) {
		System.out.println("Ket noi CSDL...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/data";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement stmt = conn.createStatement();
			
			// Insert data
//			String sql21 = "insert into Table1(Id,Name,Address,Total) values(6, 'Phan Văn Toàn', 'Huế', 1234)";
//			stmt.executeUpdate(sql21);
			//Update data: Total = Total + Total * 0.1
			String sql22 = "update Table1 set Total = Total + Total * 0.1";
			stmt.executeUpdate(sql22);
				
			String sql = "select * from Table1";
			ResultSet rs = stmt.executeQuery(sql);
				
			while(rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                double total = rs.getDouble("Total");
                
                System.out.println("ID: " + id + " Name: " + name + " Address: " + address + " Total: " + total);
                System.out.println("\n");
            }
			rs.close();
			stmt.close();
		} catch (Exception e) {
            System.out.println("Error: " + e);
        }
	}
}
