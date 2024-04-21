package hitoan.me.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hitoan.me.model.User;

public class UserDao {
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "SELECT * FROM USER";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("ID"));
				user.setName(resultSet.getString("NAME"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setUsername(resultSet.getString("USERNAME"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setRole(resultSet.getString("ROLE"));
				user.setFavourites(resultSet.getString("FAVOURITES"));
				user.setAbout(resultSet.getString("ABOUT"));

				users.add(user);
			}
		} catch (Exception e) {
			System.out.println("Error UserDao: " + e.getMessage());
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "SELECT * FROM USER WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();

				user.setId(resultSet.getInt("ID"));
				user.setName(resultSet.getString("NAME"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setUsername(resultSet.getString("USERNAME"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setRole(resultSet.getString("ROLE"));
				user.setFavourites(resultSet.getString("FAVOURITES"));
				user.setAbout(resultSet.getString("ABOUT"));

				return user;
			}
		} catch (SQLException e) {
			System.out.println("Error UserDao: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public void addUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "INSERT INTO USER(NAME, EMAIL, USERNAME, PASSWORD, ROLE, FAVOURITES, ABOUT) VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getFavourites());
			preparedStatement.setString(7, user.getAbout());

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			System.out.println("Error UserDao: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "UPDATE USER SET NAME = ?, EMAIL = ?, USERNAME = ?, PASSWORD = ?, ROLE = ?, "
				+ "FAVOURITES = ?, ABOUT = ? WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getFavourites());
			preparedStatement.setString(7, user.getAbout());
			preparedStatement.setInt(8, user.getId());

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			System.out.println("Error UserDao: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteUser(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "DELETE FROM USER WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			System.out.println("Error UserDao: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void editUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "UPDATE USER SET NAME = ?, EMAIL = ?, USERNAME = ?, PASSWORD = ?, ROLE = ?, "
				+ "FAVOURITES = ?, ABOUT = ? WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getFavourites());
			preparedStatement.setString(7, user.getAbout());
			preparedStatement.setInt(8, user.getId());

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			System.out.println("Error UserDao: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
