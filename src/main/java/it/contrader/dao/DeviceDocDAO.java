package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.DeviceDoc;

public class DeviceDocDAO {

	private final String QUERY_ALL_DD = "select * from devices";
	private final String QUERY_READ_DD = "select * from devices where dev_id =?";

	private final String QUERY_UPDATE_DD = "UPDATE devices SET min_press =?, max_press =?, min_cir =?, max_cir =?, min_breath =?, max_breath =?, min_temp =?, max_temp =? WHERE dev_id =?";

	public DeviceDocDAO() {

	}

	public List<DeviceDoc> getAllDeviceDoc() {
		List<DeviceDoc> devicesDocList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_DD);
			DeviceDoc deviceDoc;
			while (resultSet.next()) {
				int devId = resultSet.getInt("dev_id");
				String regnumber = resultSet.getString("reg_number");
				String devtype = resultSet.getString("dev_type");
				String description = resultSet.getString("description");
				int minpress = resultSet.getInt("min_press");
				int maxpress = resultSet.getInt("max_press");
				int mincir = resultSet.getInt("min_cir");
				int maxcir = resultSet.getInt("max_cir");
				int minbreath = resultSet.getInt("min_breath");
				int maxbreath = resultSet.getInt("max_breath");
				float mintemp = resultSet.getFloat("min_temp");
				float maxtemp = resultSet.getFloat("max_temp");
				deviceDoc = new DeviceDoc(regnumber, devtype, description, minpress, maxpress, mincir, maxcir, minbreath, maxbreath, mintemp, maxtemp);
				deviceDoc.setDevId(devId);
				devicesDocList.add(deviceDoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesDocList;
	}


	public DeviceDoc readDeviceDoc(int devId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_DD);
			preparedStatement.setInt(1, devId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String regnumber, devtype, description;
			int minpress, maxpress, mincir, maxcir, minbreath, maxbreath;
			float mintemp, maxtemp;
			
			regnumber = resultSet.getString("reg_number");
			devtype = resultSet.getString("dev_type");
			description = resultSet.getString("description");
			minpress = resultSet.getInt("min_press");
			maxpress = resultSet.getInt("max_press");
			mincir = resultSet.getInt("min_cir");
			maxcir = resultSet.getInt("max_cir");
			minbreath = resultSet.getInt("min_breath");
			maxbreath = resultSet.getInt("max_breath");
			mintemp = resultSet.getFloat("min_temp");
			maxtemp = resultSet.getFloat("max_temp");
			DeviceDoc deviceDoc = new DeviceDoc(regnumber, devtype, description,minpress, maxpress, mincir, maxcir, minbreath, maxbreath,mintemp, maxtemp);
			deviceDoc.setDevId(resultSet.getInt("dev_id"));

			return deviceDoc;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateDeviceDoc(DeviceDoc deviceDocToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (deviceDocToUpdate.getDevId() == 0)
			return false;

		DeviceDoc deviceDocRead = readDeviceDoc(deviceDocToUpdate.getDevId());
		if (!deviceDocRead.equals(deviceDocToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (deviceDocToUpdate.getMinpress() < 0) {
					deviceDocToUpdate.setMinpress(deviceDocRead.getMinpress());
				}

				
				if (deviceDocToUpdate.getMaxpress() < 0) {
					deviceDocToUpdate.setMaxpress(deviceDocRead.getMaxpress());
				}

				
				if (deviceDocToUpdate.getMincir() < 0) {
					deviceDocToUpdate.setMincir(deviceDocRead.getMincir());
				}

				
				if (deviceDocToUpdate.getMaxcir() < 0) {
					deviceDocToUpdate.setMaxcir(deviceDocRead.getMaxcir());
				}

				
				if (deviceDocToUpdate.getMinbreath() < 0) {
					deviceDocToUpdate.setMinbreath(deviceDocRead.getMinbreath());
				}

				
				if (deviceDocToUpdate.getMaxbreath() < 0) {
					deviceDocToUpdate.setMaxbreath(deviceDocRead.getMaxbreath());
				}

				
				if (deviceDocToUpdate.getMintemp() < 0) {
					deviceDocToUpdate.setMintemp(deviceDocRead.getMintemp());
				}

				
				if (deviceDocToUpdate.getMaxtemp() < 0) {
					deviceDocToUpdate.setMaxtemp(deviceDocRead.getMaxtemp());
				}


				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE_DD);
				//preparedStatement.setString(1, deviceDocToUpdate.getRegnumber());
				//preparedStatement.setString(2, deviceDocToUpdate.getDevtype());
				//preparedStatement.setString(3, deviceDocToUpdate.getDescription());
				preparedStatement.setInt(1, deviceDocToUpdate.getMinpress());
				preparedStatement.setInt(2, deviceDocToUpdate.getMaxpress());
				preparedStatement.setInt(3, deviceDocToUpdate.getMincir());
				preparedStatement.setInt(4, deviceDocToUpdate.getMaxcir());
				preparedStatement.setInt(5, deviceDocToUpdate.getMinbreath());
				preparedStatement.setInt(6, deviceDocToUpdate.getMaxbreath());
				preparedStatement.setFloat(7, deviceDocToUpdate.getMintemp());
				preparedStatement.setFloat(8, deviceDocToUpdate.getMaxtemp());
				preparedStatement.setInt(9, deviceDocToUpdate.getDevId());
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

}
