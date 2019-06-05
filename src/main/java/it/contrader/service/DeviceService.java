package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterDevice;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.DeviceDAO;
import it.contrader.dto.DeviceDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Device;
import it.contrader.model.User;

public class DeviceService {

	private DeviceDAO deviceDAO;

	public DeviceService() {
		this.deviceDAO = new DeviceDAO();
	}

	public List<DeviceDTO> getAllDevice() {
		
		List<Device> list = deviceDAO.getAllDevice();
		List<DeviceDTO> listDTO = new ArrayList<>();

		for (Device devices : list) {
			listDTO.add(ConverterDevice.toDTO(devices));
		}

		return listDTO;
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
