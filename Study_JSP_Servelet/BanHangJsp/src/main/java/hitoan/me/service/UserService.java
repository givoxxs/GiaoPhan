package hitoan.me.service;

import java.util.List;

import hitoan.me.dao.UserDao;
import hitoan.me.model.User;

public class UserService {
	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public void editUser(User user) {
		userDao.editUser(user);
	}
}
