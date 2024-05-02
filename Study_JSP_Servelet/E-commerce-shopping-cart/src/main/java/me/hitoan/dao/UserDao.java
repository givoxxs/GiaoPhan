package me.hitoan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import me.hitoan.model.User;

public class UserDao {
	private Connection conn;
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDao(Connection conn) {
        this.conn = conn;
    }
	
	public User userLogin(String email, String password) {
        User user = null;  
        try {
            query = "SELECT * FROM users WHERE email = ? AND PASSWORD = ?";
            // this statement is vulnerable to SQL injection
            ps = this.conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
		return user;   
	}
}
