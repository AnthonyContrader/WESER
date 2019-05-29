package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterDevice;
import it.contrader.dao.DeviceDAO;
import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

public class DeviceService {

	private DeviceDAO deviceDAO;

	public DeviceService() {
		this.deviceDAO = new DeviceDAO();
	}

	public List<Device> getAllDevice() {
		return this.deviceDAO.getAllDevice();
	}

	public boolean insertDevice(DeviceDTO deviceDTO) {
		return this.deviceDAO.insertDevice(ConverterDevice.toEntity(deviceDTO));
	}
	
	public DeviceDTO readDevice(int devId) {
		return ConverterDevice.toDTO(this.deviceDAO.readDevice(devId));
	}
	
	public boolean updateDevice(DeviceDTO deviceDTO) {
		return this.deviceDAO.updateDevice(ConverterDevice.toEntity(deviceDTO));
	}
	
	public boolean deleteDevice(int devId) {
		return this.deviceDAO.deleteDevice(devId);
	}
	
	
}
