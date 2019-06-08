package it.contrader.dao;
import it.contrader.model.Doctor;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

	private final String QUERY_ALL = "select * from cares";
	private final String QUERY_INSERT = "insert into cares (pat_name, pat_cf,pat_age, patology,care_name,quantity,notes) values (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from cares where care_id=?";

	private final String QUERY_UPDATE = "UPDATE cares SET pat_name=?, pat_cf=?,pat_age=?, patology=?,care_name=?,quantity=?,notes=? WHERE care_id=?";
	private final String QUERY_DELETE = "delete from cares where care_id=?";

	public DoctorDAO() {

	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> doctorsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Doctor doctor;
			while (resultSet.next()) {
				int careId = resultSet.getInt("care_id");
				String patname = resultSet.getString("pat_name");
				String patcf = resultSet.getString("pat_cf");
				int patage = resultSet.getInt("pat_age");
				String patology = resultSet.getString("patology");
				String carename = resultSet.getString("care_name");
				String quantity = resultSet.getString("quantity");
				String notes = resultSet.getString("notes");
				doctor = new Doctor(patname, patcf,patage,patology,carename,quantity,notes);
				doctor.setCareid(careId);;
				doctorsList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorsList;
	}

	public boolean insertDoctor(Doctor doctor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, doctor.getParname());
			preparedStatement.setString(2, doctor.getPatcf());
			preparedStatement.setInt(3, doctor.getPatage());
			preparedStatement.setString(4, doctor.getPatology());
			preparedStatement.setString(5, doctor.getCarename());
			preparedStatement.setString(6, doctor.getQuantity());
			preparedStatement.setString(7, doctor.getNotes());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Doctor readDoctor(Doctor doctor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int doctorId = doctor.getCareid();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, doctorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String patname,patcf,patology,carename,quantity,notes;
			int patage;

			patname = resultSet.getString("pat_name");
			patcf = resultSet.getString("pat_cf");
			patage = resultSet.getInt("pat_age");
			patology = resultSet.getString("patology");
			carename = resultSet.getString("care_name");
			quantity = resultSet.getString("quantity");
			notes = resultSet.getString("notes");
			doctor = new Doctor(patname,patcf, patage, patology,carename,quantity,notes);
			doctor.setCareid(resultSet.getInt("care_id"));

			return doctor;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateDoctor(Doctor doctorToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (doctorToUpdate.getCareid() == 0)
			return false;

		// Doctor doctorRead = readDoctor(doctorToUpdate);
		// if (!doctorRead.equals(doctorToUpdate)) {
		try {
			// Fill the doctorToUpdate object
			/*
			if (doctorToUpdate.getDoctorname() == null || doctorToUpdate.getDoctorname().equals("")) {
			 
				doctorToUpdate.setDoctor(doctorRead.getDoctorname());
			}

			if (doctorToUpdate.getPassword() == null || doctorToUpdate.getPassword().equals("")) {
				doctorToUpdate.setPassword(doctorRead.getPassword());
			}

			if (doctorToUpdate.getDoctortype() == null || doctorToUpdate.getDoctortype().equals("")) {
				doctorToUpdate.setDoctortype(doctorRead.getDoctortype());
			}
			
			*/
			// Update the doctor
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, doctorToUpdate.getParname());
			preparedStatement.setString(2, doctorToUpdate.getPatcf());
			preparedStatement.setInt(3, doctorToUpdate.getPatage());
			preparedStatement.setString(4, doctorToUpdate.getPatology());
			preparedStatement.setString(5, doctorToUpdate.getCarename());
			preparedStatement.setString(6, doctorToUpdate.getQuantity());
			preparedStatement.setString(7, doctorToUpdate.getNotes());
			preparedStatement.setInt(8, doctorToUpdate.getCareid());
			preparedStatement.execute();

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

	public boolean deleteDoctor(Doctor doctor) {
		int id = doctor.getCareid();
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
