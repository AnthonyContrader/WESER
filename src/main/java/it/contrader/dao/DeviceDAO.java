package it.contrader.dao;
import it.contrader.model.Device;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAO {

	private final String QUERY_ALL = "select * from devices";
	private final String QUERY_INSERT = "insert into devices (reg_number, dev_type,description,min_press,max_press,min_cir,max_cir,min_breath,max_breath,min_temp,max_temp,) values (?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from devices where dev_id=?";

	private final String QUERY_UPDATE = "UPDATE devices SET reg_number=?, dev_type=?,description=?, min_press=?,max_press=?,min_cir=?,max_cir=?,,min_breath=?,max_breath=?,min_temp=?,max_temp=? WHERE dev_id=?";
	private final String QUERY_DELETE = "delete from devices where devId=?";
	public DeviceDAO() {

	}

	public List<Device> getAllDevice() {
		List<Device> devicesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Device device;
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
				float mintemp = resultSet.getInt("min_temp");
				float maxtemp = resultSet.getInt("max_temp");
				device = new Device(regnumber,devtype,description,minpress,maxpress,mincir,maxcir,minbreath,maxbreath,mintemp,maxtemp);
				device.setDevId(devId);
				devicesList.add(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesList;
	}

	public boolean insertDevice(Device device) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, device.getRegnumber());
			preparedStatement.setString(2, device.getDevtype());
			preparedStatement.setString(3, device.getDescription());
			preparedStatement.setInt(4, device.getMinpress());
			preparedStatement.setInt(5, device.getMaxpress());
			preparedStatement.setInt(6, device.getMincir());
			preparedStatement.setInt(7, device.getMaxcir());
			preparedStatement.setInt(8, device.getMinbreath());
			preparedStatement.setInt(9, device.getMaxbreath());
			preparedStatement.setFloat(10, device.getMintemp());
			preparedStatement.setFloat(11, device.getMaxtemp());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Device readDevice(Device device) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int devId = device.getDevId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, devId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String regnumber,devtype,description;
			int minpress,maxpress,mincir,maxcir,minbreath,maxbreath;
			float mintemp,maxtemp;

			regnumber = resultSet.getString("reg_number");
			devtype = resultSet.getString("dev_type");
			description = resultSet.getString("description");
			minpress = resultSet.getInt("min_press");
			maxpress = resultSet.getInt("max_press");
			mincir = resultSet.getInt("min_cir");
			maxcir = resultSet.getInt("max_cir");
			minbreath = resultSet.getInt("min_breath");
			maxbreath = resultSet.getInt("max_breath");
			mintemp = resultSet.getInt("min_temp");
			maxtemp = resultSet.getInt("max_temp");
			device = new Device(regnumber,devtype,description,minpress,maxpress,mincir,maxcir,minbreath,maxbreath,mintemp,maxtemp);
			device.setDevId(devId);
			device.setDevId(resultSet.getInt("dev_id"));

			return device;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateDevice(Device deviceToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (deviceToUpdate.getDevId() == 0)
			return false;

		// Device deviceRead = readDevice(deviceToUpdate);
		// if (!deviceRead.equals(deviceToUpdate)) {
		try {
			// Fill the deviceToUpdate object
			/*
			if (deviceToUpdate.getDevicename() == null || deviceToUpdate.getDevicename().equals("")) {
			 
				deviceToUpdate.setDevice(deviceRead.getDevicename());
			}

			if (deviceToUpdate.getPassword() == null || deviceToUpdate.getPassword().equals("")) {
				deviceToUpdate.setPassword(deviceRead.getPassword());
			}

			if (deviceToUpdate.getDevicetype() == null || deviceToUpdate.getDevicetype().equals("")) {
				deviceToUpdate.setDevicetype(deviceRead.getDevicetype());
			}
			
			*/
			// Update the device
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, deviceToUpdate.getRegnumber());
			preparedStatement.setString(2, deviceToUpdate.getDevtype());
			preparedStatement.setString(3, deviceToUpdate.getDescription());
			preparedStatement.setInt(4, deviceToUpdate.getMinpress());
			preparedStatement.setInt(5, deviceToUpdate.getMaxpress());
			preparedStatement.setInt(6, deviceToUpdate.getMincir());
			preparedStatement.setInt(7, deviceToUpdate.getMaxcir());
			preparedStatement.setInt(8, deviceToUpdate.getMinbreath());
			preparedStatement.setInt(9, deviceToUpdate.getMaxbreath());
			preparedStatement.setFloat(10, deviceToUpdate.getMintemp());
			preparedStatement.setFloat(11, deviceToUpdate.getMaxtemp());
			preparedStatement.setInt(12, deviceToUpdate.getDevId());
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

	public boolean deleteDevice(Device device) {
		int devId = device.getDevId();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, devId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}


}
