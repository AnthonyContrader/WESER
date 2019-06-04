package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Care;

public class CareDAO {

	private final String QUERY_ALL_C = "select * from cares";
	private final String QUERY_INSERT_C = "insert into cares (pat_name, pat_cf, pat_age, patology, care_name, quantity, notes) values (?,?,?,?,?,?,?)";
	private final String QUERY_READ_C = "select * from cares where care_id = ?";

	private final String QUERY_UPDATE_C = "UPDATE cares SET pat_name = ?, pat_cf = ?, pat_age = ?, patology = ?, care_name = ?, quantity = ?, notes = ? WHERE care_id = ?";
	private final String QUERY_DELETE_C = "delete from cares where care_id = ?";

	public CareDAO() {

	}

	public List<Care> getAllCare() {
		List<Care> caresList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_C);
			Care care;
			while (resultSet.next()) {
				int careId = resultSet.getInt("care_id");
				String patname = resultSet.getString("pat_name");
				String patcf = resultSet.getString("pat_cf");
				int patage = resultSet.getInt("pat_age");
				String patology = resultSet.getString("patology");
				String carename = resultSet.getString("care_name");
				String quantity = resultSet.getString("quantity");
				String notes = resultSet.getString("notes");
				care = new Care(patname, patcf, patage, patology, carename, quantity, notes);
				care.setCareId(careId);
				caresList.add(care);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caresList;
	}

	public boolean insertCare(Care care) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_C);
			preparedStatement.setString(1, care.getPatname());
			preparedStatement.setString(2, care.getPatcf());
			preparedStatement.setInt(3, care.getPatage());
			preparedStatement.setString(4, care.getPatology());
			preparedStatement.setString(5, care.getCarename());
			preparedStatement.setString(6, care.getQuantity());
			preparedStatement.setString(7, care.getNotes());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Care readCare(int careId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_C);
			preparedStatement.setInt(1, careId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String patname, patcf, patology, carename, quantity, notes;
			int patage;

			patname = resultSet.getString("pat_name");
			patcf = resultSet.getString("pat_cf");
			patage = resultSet.getInt("pat_age");
			patology = resultSet.getString("patology");
			carename = resultSet.getString("care_name");
			quantity = resultSet.getString("quantity");
			notes = resultSet.getString("notes");
			Care care = new Care(patname, patcf, patage, patology, carename, quantity, notes);
			care.setCareId(resultSet.getInt("care_id"));

			return care;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateCare(Care careToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (careToUpdate.getCareId() == 0)
			return false;

		Care careRead = readCare(careToUpdate.getCareId());
		if (!careRead.equals(careToUpdate)) {
			try {
				// Fill the careToUpdate object
				if (careToUpdate.getPatname() == null || careToUpdate.getPatname().equals("")) {
					careToUpdate.setPatname(careRead.getPatname());
				}
				
				
				if (careToUpdate.getPatcf() == null || careToUpdate.getPatcf().equals("")) {
					careToUpdate.setPatcf(careRead.getPatcf());
				}
				
				if (careToUpdate.getPatage() < 0 ) {
					careToUpdate.setPatage(careRead.getPatage());
				}
				
				if (careToUpdate.getPatology() == null || careToUpdate.getPatology().equals("")) {
					careToUpdate.setPatology(careRead.getPatology());
				}
				
				if (careToUpdate.getCarename() == null || careToUpdate.getCarename().equals("")) {
					careToUpdate.setCarename(careRead.getCarename());
				}
				
				if (careToUpdate.getQuantity() == null || careToUpdate.getQuantity().equals("")) {
					careToUpdate.setQuantity(careRead.getQuantity());
				}
				if (careToUpdate.getNotes() == null || careToUpdate.getNotes().equals("")) {
						careToUpdate.setNotes(careRead.getNotes());	
				
				}
				// Update the care
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE_C);
				preparedStatement.setString(1, careToUpdate.getPatname());
				preparedStatement.setString(2, careToUpdate.getPatcf());
				preparedStatement.setInt(3, careToUpdate.getPatage());
				preparedStatement.setString(4, careToUpdate.getPatology());
				preparedStatement.setString(5, careToUpdate.getCarename());
				preparedStatement.setString(6, careToUpdate.getQuantity());
				preparedStatement.setString(7, careToUpdate.getNotes());
				preparedStatement.setInt(8, careToUpdate.getCareId());
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

	public boolean deleteCare(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_C);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
