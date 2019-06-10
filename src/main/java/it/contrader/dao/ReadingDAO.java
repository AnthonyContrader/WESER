package it.contrader.dao;

import it.contrader.model.Reading;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadingDAO {

	private final String QUERY_ALL = "select * from readings";
	private final String QUERY_INSERT = "insert into readings (patcf, regdev,minpress,maxpress,mincir,maxcir,minbreath,maxbreath,mintemp,maxtemp) values (?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from readings where readid=?";
	private final String QUERY_DELETE = "delete from readings where readid=?";
	public ReadingDAO() {

	}

	public List<Reading> getAllReading() {
		List<Reading> readingsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Reading reading;
			while (resultSet.next()) {
				int readId = resultSet.getInt("readid");
				String patcf = resultSet.getString("patcf");
				String regdev = resultSet.getString("regdev");
				int minpress = resultSet.getInt("minpress");
				int maxpress = resultSet.getInt("maxpress");
				int mincir = resultSet.getInt("mincir");
				int maxcir = resultSet.getInt("maxcir");
				int minbreath = resultSet.getInt("minbreath");
				int maxbreath = resultSet.getInt("maxbreath");
				float mintemp = resultSet.getFloat("mintemp");
				float maxtemp = resultSet.getFloat("maxtemp");
				reading = new Reading(patcf,regdev,minpress,maxpress,mincir,maxcir,minbreath,maxbreath,mintemp,maxtemp);
				reading.setReadId(readId);
				readingsList.add(reading);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return readingsList;
	}

	public boolean insertReading(Reading reading) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, reading.getPatcf());
			preparedStatement.setString(2, reading.getRegdev());
			preparedStatement.setInt(3, reading.getMinpress());
			preparedStatement.setInt(4, reading.getMaxpress());
			preparedStatement.setInt(5, reading.getMincir());
			preparedStatement.setInt(6, reading.getMaxcir());
			preparedStatement.setInt(7, reading.getMinbreath());
			preparedStatement.setInt(8, reading.getMaxbreath());
			preparedStatement.setFloat(9, reading.getMintemp());
			preparedStatement.setFloat(10, reading.getMaxtemp());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Reading readReading(Reading reading) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int readId = reading.getReadId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, readId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String patcf,regdev;
			int minpress,maxpress,mincir,maxcir,minbreath,maxbreath;
			float mintemp,maxtemp;
			readId= resultSet.getInt("readid");
			patcf = resultSet.getString("patcf");
			regdev = resultSet.getString("regdev");
			minpress = resultSet.getInt("minpress");
			maxpress = resultSet.getInt("maxpress");
			mincir = resultSet.getInt("mincir");
			maxcir = resultSet.getInt("maxcir");
			minbreath = resultSet.getInt("minbreath");
			maxbreath = resultSet.getInt("maxbreath");
			mintemp = resultSet.getFloat("mintemp");
			maxtemp = resultSet.getFloat("maxtemp");
			reading = new Reading(patcf,regdev,minpress,maxpress,mincir,maxcir,minbreath,maxbreath,mintemp,maxtemp);
			reading.setReadId(readId);
			reading.setReadId(resultSet.getInt("readid"));

			return reading;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	

	public boolean deleteReading(Reading reading) {
		int readId = reading.getReadId();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, readId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}


}
