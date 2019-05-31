package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterEmergency;
import it.contrader.dao.EmergencyDAO;
import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;

public class EmergencyService {

	private EmergencyDAO emergencyDAO;

	public EmergencyService() {
		this.emergencyDAO = new EmergencyDAO();
	}

	public List<Emergency> getAllEmergency() {
		return this.emergencyDAO.getAllEmergency();
	}

	public boolean insertEmergency(EmergencyDTO emergencyDTO) {
		return this.emergencyDAO.insertEmergency(ConverterEmergency.toEntity(emergencyDTO));
	}
	
	public EmergencyDTO readEmergency(int emergencyId) {
		return ConverterEmergency.toDTO(this.emergencyDAO.readEmergency(emergencyId));
	}
	
	public boolean updateEmergency(EmergencyDTO emergencyDTO) {
		return this.emergencyDAO.updateEmergency(ConverterEmergency.toEntity(emergencyDTO));
	}
	
	public boolean deleteEmergency(int Id_em) {
		return this.emergencyDAO.deleteEmergency(Id_em);
	}
	
	
}
