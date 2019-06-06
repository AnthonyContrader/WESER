package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.DeviceConverter;
import it.contrader.dao.DeviceDAO;
import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class DeviceServiceDTO {

	private final DeviceDAO deviceDAO;

	public DeviceServiceDTO() {
		this.deviceDAO = new DeviceDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<DeviceDTO> getAllDevices() {

		List<Device> list = deviceDAO.getAllDevice();
		List<DeviceDTO> listDTO = new ArrayList<>();

		for (Device device : list) {
			listDTO.add(DeviceConverter.toDTO(device));
		}

		return listDTO;
	}
	

	public DeviceDTO readDevice(DeviceDTO deviceDTO) {
		return DeviceConverter.toDTO(this.deviceDAO.readDevice(DeviceConverter.toEntity(deviceDTO)));
	}
	
	public boolean updateDevice(DeviceDTO deviceDTO) {
		return this.deviceDAO.updateDevice(DeviceConverter.toEntity(deviceDTO));
		
}
	
	public boolean deleteDevices (DeviceDTO deviceDTO) {
		return this.deviceDAO.deleteDevice(DeviceConverter.toEntity(deviceDTO));
		
}
	
	public boolean insertDevices (DeviceDTO devicesDTO) {
		return this.deviceDAO.insertDevice(DeviceConverter.toEntity(devicesDTO));
	
}
		
	
	
}
