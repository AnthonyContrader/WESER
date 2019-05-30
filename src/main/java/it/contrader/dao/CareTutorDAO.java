package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.CareTutor;

public class CareTutorDAO {

	private final String QUERY_ALL_CT = "select * from cares";
	private final String QUERY_INSERT_CT = "insert into cares (pat_name, pat_cf, pat_age, patology, care_name, quantity,notes) values (?,?,?,?,?,?,?)";
	private final String QUERY_READ_CT = "select * from cares where care_id = ?";

	private final String QUERY_UPDATE_CT = "UPDATE cares SET pat_name = ?, pat_cf = ?, pat_age = ?, patology =? ,care_name = ?, quantity = ?, notes = ? WHERE care_id = ?";
	private final String QUERY_DELETE_CT = "delete from cares where care_id = ?";

	public CareTutorDAO() {

	}

	public List<CareTutor> getAllCareTutor() {
		List<CareTutor> caresTutorList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_CT);
			CareTutor careTutor;
			while (resultSet.next()) {
				int careid = resultSet.getInt("care_id");
				String patname = resultSet.getString("pat_name");
				String patcf= resultSet.getString("pat_cf");
				int patage = resultSet.getInt("pat_age");
				String patology = resultSet.getString("patology");
				String care_name = resultSet.getString("care_name");
				String quantity = resultSet.getString("quantity");
				String notes = resultSet.getString("notes");

				careTutor = new CareTutor(patname,patage, patcf, patology, care_name, quantity,notes);
				careTutor.setCareTutorcareid(careid);
				caresTutorList.add(careTutor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caresTutorList;
	}

	public boolean insertCareTutor(CareTutor careTutor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_CT);
			preparedStatement.setString(1, careTutor.getCareTutorpatname());
			preparedStatement.setString(2, careTutor.getCareTutorpatcf());
			preparedStatement.setInt(3, careTutor.getCareTutorpatage());
			preparedStatement.setString(4, careTutor.getCareTutorpatology());
			preparedStatement.setString(5, careTutor.getCareTutorcarename());
			preparedStatement.setString(6, careTutor.getCareTutorquantity());
			preparedStatement.setString(7, careTutor.getCareTutornotes());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public CareTutor readCareTutor(int careId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_CT);
			preparedStatement.setInt(1, careId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String patname,patcf, patology, carename, quantity, notes;
			int patage;

			patname = resultSet.getString("pat_name");
			patcf = resultSet.getString("pat_cf");
			patage = resultSet.getInt("pat_age");
			patology = resultSet.getString("patology");
			carename = resultSet.getString("care_name");
			quantity = resultSet.getString("quantity");
			notes = resultSet.getString("notes");
			CareTutor careTutor = new CareTutor(patname,patage,patcf,patology,carename,quantity,notes);
			careTutor.setCareTutorcareid(resultSet.getInt("care_id"));

			return careTutor;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateCareTutor(CareTutor careToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (careToUpdate.getCareTutorcareid() == 0)
			return false;

		CareTutor careRead = readCareTutor(careToUpdate.getCareTutorcareid());
		if (!careRead.equals(careToUpdate)) {
			try {
				// Fill the careToUpdate object
				if (careToUpdate.getCareTutorpatname() == null || careToUpdate.getCareTutorpatname().equals("")) {
					careToUpdate.setCareTutorpatname(careRead.getCareTutorpatname());
				}
				
				
				if (careToUpdate.getCareTutorpatcf() == null || careToUpdate.getCareTutorpatcf().equals("")) {
					careToUpdate.setCareTutorpatcf(careRead.getCareTutorpatcf());
				}
				
				if (careToUpdate.getCareTutorpatage() <0) {
					careToUpdate.setCareTutorpatage(careRead.getCareTutorpatage());
				}
				
				if (careToUpdate.getCareTutorpatology() == null || careToUpdate.getCareTutorpatology().equals("")) {
					careToUpdate.setCareTutorpatology(careRead.getCareTutorpatology());
				}
				
				if (careToUpdate.getCareTutorcarename() == null || careToUpdate.getCareTutorcarename().equals("")) {
					careToUpdate.setCareTutorcarename(careRead.getCareTutorcarename());
				}
				
				if (careToUpdate.getCareTutorquantity() == null || careToUpdate.getCareTutorquantity().equals("")) {
					careToUpdate.setCareTutorquantity(careRead.getCareTutorquantity());
				}
				
				if (careToUpdate.getCareTutornotes() == null || careToUpdate.getCareTutornotes().equals("")) {
					careToUpdate.setCareTutornotes(careRead.getCareTutornotes());
				}
				// Update the care
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE_CT);
				preparedStatement.setString(1, careToUpdate.getCareTutorpatname());
				preparedStatement.setString(2, careToUpdate.getCareTutorpatcf());
				preparedStatement.setInt(3, careToUpdate.getCareTutorpatage());
				preparedStatement.setString(4, careToUpdate.getCareTutorpatology());
				preparedStatement.setString(5, careToUpdate.getCareTutorcarename());
				preparedStatement.setString(6, careToUpdate.getCareTutorquantity());
				preparedStatement.setString(6, careToUpdate.getCareTutornotes());
				preparedStatement.setInt(7, careToUpdate.getCareTutorcareid());
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

	public boolean deleteCareTutor(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_CT);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
