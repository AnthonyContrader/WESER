package it.contrader.dao;
import it.contrader.model.Patology;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatologyDAO {

	private final String QUERY_ALL = "select * from patology";
	private final String QUERY_INSERT = "insert into patology (patology,carename,quantity,patcf,patominpress,patomaxpress,patomincir,patomaxcir,patominbreath,patomaxbreath,patomintemp,patomaxtemp) values (?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from patology where patologyid=?";

	private final String QUERY_UPDATE = "UPDATE patology SET patology=?,carename=?,quantity=?,patcf=?,patominpress=?,patomaxpress=?,patomincir=?,patomaxcir=?,patominbreath=?,patomaxbreath=?,patomintemp=?,patomaxtemp=? WHERE patologyid=?";
	private final String QUERY_DELETE = "delete from patology where patologyid=?";

	public PatologyDAO() {

	}

	public List<Patology> getAllPatology() {
		List<Patology> patologysList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Patology patology;
			while (resultSet.next()) {
				int patologyid = resultSet.getInt("patologyid");
				String pato = resultSet.getString("patology");
				String carename = resultSet.getString("carename");
				String quantity = resultSet.getString("quantity");
				String patcf = resultSet.getString("patcf");
				int patominpress = resultSet.getInt("patominpress");
				int patomaxpress = resultSet.getInt("patomaxpress");
				int patomincir = resultSet.getInt("patomincir");
				int patomaxcir = resultSet.getInt("patomaxcir");
				int patominbreath = resultSet.getInt("patominbreath");
				int patomaxbreath = resultSet.getInt("patomaxbreath");
				float patomintemp	 = resultSet.getInt("patomintemp");
				float patomaxtemp = resultSet.getInt("patomaxtemp");
				
				patology = new Patology(pato,carename,quantity,patcf,patominpress,patomaxpress,patomincir,patomaxcir,patominbreath,patomaxbreath,patomintemp,patomaxtemp);
				patology.setPatologyid(patologyid);
				patologysList.add(patology);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patologysList;
	}

	public boolean insertPatology(Patology patology) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, patology.getPatology());
			preparedStatement.setString(2, patology.getCarename());
			preparedStatement.setString(3, patology.getQuantity());
			preparedStatement.setString(4, patology.getPatcf());
			preparedStatement.setInt(5, patology.getPatominpress());
			preparedStatement.setInt(6, patology.getPatomaxpress());
			preparedStatement.setInt(7, patology.getPatomincir());
			preparedStatement.setInt(8, patology.getPatomaxcir());
			preparedStatement.setInt(9, patology.getPatominbreath());
			preparedStatement.setInt(10, patology.getPatomaxbreath());
			preparedStatement.setFloat(11, patology.getPatomintemp());
			preparedStatement.setFloat(12, patology.getPatomaxtemp());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Patology readPatology(Patology patology) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int devid = patology.getPatologyid();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, devid);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String pato,carename,quantity,patcf;
			int patominpress,patomaxpress,patomincir,patomaxcir,patominbreath,patomaxbreath;
			float patomintemp,patomaxtemp;
			
			pato = resultSet.getString("patology");
			carename = resultSet.getString("carename");
			quantity = resultSet.getString("quantity");
			patcf = resultSet.getString("patcf");
			patominpress = resultSet.getInt("patominpress");
			patomaxpress = resultSet.getInt("patomaxpress");
			patomincir = resultSet.getInt("patomincir");
			patomaxcir = resultSet.getInt("patomaxcir");
			patominbreath = resultSet.getInt("patominbreath");
			patomaxbreath = resultSet.getInt("patomaxbreath");
			patomintemp	 = resultSet.getInt("patomintemp");
			patomaxtemp = resultSet.getInt("patomaxtemp");
			
			patology = new Patology(pato,carename,quantity,patcf,patominpress,patomaxpress,patomincir,patomaxcir,patominbreath,patomaxbreath,patomintemp,patomaxtemp);
			patology.setPatologyid(resultSet.getInt("patologyid"));

			return patology;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updatePatology(Patology patologyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (patologyToUpdate.getPatologyid() == 0)
			return false;

		// Patology patologyRead = readPatology(patologyToUpdate);
		// if (!patologyRead.equals(patologyToUpdate)) {
		try {
			// Fill the patologyToUpdate object
			/*
			if (patologyToUpdate.getPatologyname() == null || patologyToUpdate.getPatologyname().equals("")) {
			 
				patologyToUpdate.setPatology(patologyRead.getPatologyname());
			}

			if (patologyToUpdate.getPassword() == null || patologyToUpdate.getPassword().equals("")) {
				patologyToUpdate.setPassword(patologyRead.getPassword());
			}

			if (patologyToUpdate.getPatologytype() == null || patologyToUpdate.getPatologytype().equals("")) {
				patologyToUpdate.setPatologytype(patologyRead.getPatologytype());
			}
			
			*/
			// Update the patology
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, patologyToUpdate.getPatology());
			preparedStatement.setString(2, patologyToUpdate.getCarename());
			preparedStatement.setString(3, patologyToUpdate.getQuantity());
			preparedStatement.setString(4, patologyToUpdate.getPatcf());
			preparedStatement.setInt(5, patologyToUpdate.getPatominpress());
			preparedStatement.setInt(6, patologyToUpdate.getPatomaxpress());
			preparedStatement.setInt(7, patologyToUpdate.getPatomincir());
			preparedStatement.setInt(8, patologyToUpdate.getPatomaxcir());
			preparedStatement.setInt(9, patologyToUpdate.getPatominbreath());
			preparedStatement.setInt(10, patologyToUpdate.getPatomaxbreath());
			preparedStatement.setFloat(11, patologyToUpdate.getPatomintemp());
			preparedStatement.setFloat(12, patologyToUpdate.getPatomaxtemp());
			
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

	public boolean deletePatology(Patology patology) {
		int id = patology.getPatologyid();
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
