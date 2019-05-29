package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.User;

public class UserDAO {

	private final String QUERY_ALL = "select * from users";
	private final String QUERY_INSERT = "insert into users (username, user_type, password, name, surname, cf) values (?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from users where user_id = ?";

	private final String QUERY_UPDATE = "UPDATE users SET username = ?, user_type = ?, password = ?, name = ?, surname = ?, cf = ? WHERE user_id = ?";
	private final String QUERY_DELETE = "delete from users where user_id = ?";

	public UserDAO() {

	}

	public List<User> getAllUser() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("username");
				String usertype = resultSet.getString("user_type");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String cf = resultSet.getString("cf");
				user = new User(username, usertype, password, name, surname, cf);
				user.setUserId(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insertUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getUsertype());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getSurname());
			preparedStatement.setString(6, user.getCf());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public User readUser(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, usertype, password, name, surname, cf;

			username = resultSet.getString("username");
			usertype = resultSet.getString("user_type");
			password = resultSet.getString("password");
			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			cf = resultSet.getString("cf");
			User user = new User(username, usertype, password, name, surname, cf);
			user.setUserId(resultSet.getInt("user_id"));

			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateUser(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = readUser(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}
				
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}
				
				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}
				
				if (userToUpdate.getName() == null || userToUpdate.getName().equals("")) {
					userToUpdate.setName(userRead.getName());
				}
				
				if (userToUpdate.getSurname() == null || userToUpdate.getSurname().equals("")) {
					userToUpdate.setSurname(userRead.getSurname());
				}
				
				if (userToUpdate.getCf() == null || userToUpdate.getCf().equals("")) {
					userToUpdate.setCf(userRead.getCf());
				}
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(2, userToUpdate.getUsertype());
				preparedStatement.setString(3, userToUpdate.getPassword());
				preparedStatement.setString(4, userToUpdate.getName());
				preparedStatement.setString(5, userToUpdate.getSurname());
				preparedStatement.setString(6, userToUpdate.getCf());
				preparedStatement.setInt(7, userToUpdate.getUserId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}

	public boolean deleteUser(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
