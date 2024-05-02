package me.hitoan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import me.hitoan.model.Order;

public class OrderDao {
	private Connection conn;
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public OrderDao(Connection conn) {
		this.conn = conn;
	}
	
	public boolean insertOrder(Order model) {
		boolean status = false;
		
		try {
			query = "INSERT INTO orders (p_id, u_id, o_quantity, o_date) VALUES (?, ?, ?, ?)";
			ps = this.conn.prepareStatement(query);
			ps.setInt(1, model.getId());
			ps.setInt(2, model.getUserId());
			ps.setInt(3, model.getQuantity());
			ps.setString(4, model.getDate());
			ps.executeUpdate();
			
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		
		return status;
	}
}
