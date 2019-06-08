package it.contrader.dao;
import it.contrader.model.Emergency;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmergencyDAO {

	private final String QUERY_ALL = "select * from emergencys";
	private final String QUERY_INSERT = "insert into emergencys (em_num) values (?)";
	private final String QUERY_READ = "select * from emergencys where id_em=?";

	private final String QUERY_UPDATE = "UPDATE emergencys SET em_num=?";
	private final String QUERY_DELETE = "delete from emergencys where id_em=?";
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
				int emId = resultSet.getInt("id_em");
				String emnum = resultSet.getString("em_num");
				emergency = new Emergency(emnum);
				emergency.setEmId(emId);
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
			preparedStatement.setString(1, emergency.getEmnum());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Emergency readEmergency(Emergency emergency) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int emId = emergency.getEmId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, emId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String emnum;

			emnum = resultSet.getString("em_num");
			emergency = new Emergency(emnum);
			emergency.setEmId(resultSet.getInt("id_em"));

			return emergency;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateEmergency(Emergency emergencyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (emergencyToUpdate.getEmId() == 0)
			return false;

		// Emergency emergencyRead = readEmergency(emergencyToUpdate);
		// if (!emergencyRead.equals(emergencyToUpdate)) {
		try {
			// Fill the emergencyToUpdate object
			/*
			if (emergencyToUpdate.getEmergencyname() == null || emergencyToUpdate.getEmergencyname().equals("")) {
			 
				emergencyToUpdate.setEmergency(emergencyRead.getEmergencyname());
			}

			if (emergencyToUpdate.getPassword() == null || emergencyToUpdate.getPassword().equals("")) {
				emergencyToUpdate.setPassword(emergencyRead.getPassword());
			}

			if (emergencyToUpdate.getEmergencytype() == null || emergencyToUpdate.getEmergencytype().equals("")) {
				emergencyToUpdate.setEmergencytype(emergencyRead.getEmergencytype());
			}
			
			*/
			// Update the emergency
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, emergencyToUpdate.getEmnum());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			return false;
		}
		//}

		//return false;

	}

	public boolean deleteEmergency(Emergency emergency) {
		int emId = emergency.getEmId();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, emId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}}

	