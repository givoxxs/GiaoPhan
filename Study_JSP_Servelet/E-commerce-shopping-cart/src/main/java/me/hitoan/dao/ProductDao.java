package me.hitoan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import me.hitoan.model.Cart;
import me.hitoan.model.Product;

public class ProductDao {
	private Connection conn;
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;

	public ProductDao(Connection conn) {
		this.conn = conn;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();

		try {
			query = "SELECT * FROM products";
			ps = this.conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		return products;
	}

	public List<Cart> getCardProducts(ArrayList<Cart> cardList) {
		List<Cart> products = new ArrayList<Cart>();

		try {
			if (cardList.size() > 0) {
				for (Cart item : cardList) {
					query = "SELECT * FROM products WHERE id = ?";
					ps = this.conn.prepareStatement(query);
					ps.setInt(1, item.getId());
					rs = ps.executeQuery();
					while (rs.next()) {
						Cart product = new Cart();
						product.setId(rs.getInt("id"));
						product.setName(rs.getString("name"));
						product.setCategory(rs.getString("category"));
						product.setPrice(rs.getDouble("price") * item.getQuantity());
//						product.setImage(rs.getString("image"));
						product.setQuantity(item.getQuantity());
						products.add(product);
					}
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		return products;
	}

	public double getTotalCartPrice(ArrayList<Cart> cardList) {
		double total = 0;

		try {
			if (cardList.size() > 0) {
				for (Cart item : cardList) {
					query = "SELECT * FROM products WHERE id = ?";
					ps = this.conn.prepareStatement(query);
					ps.setInt(1, item.getId());
					rs = ps.executeQuery();
					while (rs.next()) {
						total += rs.getDouble("price") * item.getQuantity();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		return total;
	}

}
