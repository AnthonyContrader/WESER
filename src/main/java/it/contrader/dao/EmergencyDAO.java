package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Emergency;

public class EmergencyDAO {

	private final String QUERY_ALL = "select * from emergency";
	private final String QUERY_INSERT = "insert into emergency (em_num) values (?)";
	private final String QUERY_READ = "select * from emergency where id_em = ?";

	private final String QUERY_UPDATE = "UPDATE emergency SET em_num = ? WHERE id_em = ?";
	private final String QUERY_DELETE = "delete from emergency where id_em = ?";

	public EmergencyDAO() {

	}

	public List<Emergency> getAllEmergency() {
		List<Emergency> emergencysList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Emergency emergency;
			while (resultSet.next()) {
				int Id_em = resultSet.getInt("id_em");
				String em_num = resultSet.getString("em_num");
				emergency = new Emergency(em_num);
				emergency.setId_em(Id_em);
				emergencysList.add(emergency);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emergencysList;
	}

	public boolean insertEmergency(Emergency emergency) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, emergency.getEm_num());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Emergency readEmergency(int Id_em) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, Id_em);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String em_num;

			em_num = resultSet.getString("em_num");
			Emergency emergency = new Emergency(em_num);
			emergency.setId_em(resultSet.getInt("id_em"));

			return emergency;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateEmergency(Emergency emergencyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (emergencyToUpdate.getId_Em() == 0)
			return false;

		Emergency emergencyRead = readEmergency(emergencyToUpdate.getId_Em());
		if (!emergencyRead.equals(emergencyToUpdate)) {
			try {
				// Fill the emergencyToUpdate object
				if (emergencyToUpdate.getEm_num() == null || emergencyToUpdate.getEm_num().equals("")) {
					emergencyToUpdate.setEm_num(emergencyRead.getEm_num());
				
				}
				// Update the emergency
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, emergencyToUpdate.getEm_num());
				preparedStatement.setInt(2, emergencyToUpdate.getId_Em());
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

	public boolean deleteEmergency(Integer id) {
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
