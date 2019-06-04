package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterDeviceDoc;
import it.contrader.dao.DeviceDocDAO;
import it.contrader.dto.DeviceDocDTO;
import it.contrader.model.DeviceDoc;

public class DeviceDocService {

	private DeviceDocDAO deviceDocDAO;

	public DeviceDocService() {
		this.deviceDocDAO = new DeviceDocDAO();
	}

	public List<DeviceDoc> getAllDeviceDoc() {
		return this.deviceDocDAO.getAllDeviceDoc();
	}

	
	public DeviceDocDTO readDeviceDoc(int devId) {
		return ConverterDeviceDoc.toDTO(this.deviceDocDAO.readDeviceDoc(devId));
	}
	
	public boolean updateDeviceDoc(DeviceDocDTO deviceDocDTO) {
		return this.deviceDocDAO.updateDeviceDoc(ConverterDeviceDoc.toEntity(deviceDocDTO));
	}
	
	
	
}
