package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.EmergencyConverter;
import it.contrader.dao.EmergencyDAO;
import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class EmergencyServiceDTO {

	private final EmergencyDAO emergencyDAO;

	public EmergencyServiceDTO() {
		this.emergencyDAO = new EmergencyDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<EmergencyDTO> getAllEmergencys() {

		List<Emergency> list = emergencyDAO.getAllEmergency();
		List<EmergencyDTO> listDTO = new ArrayList<>();

		for (Emergency emergency : list) {
			listDTO.add(EmergencyConverter.toDTO(emergency));
		}

		return listDTO;
	}
	

	public EmergencyDTO readEmergency(EmergencyDTO emergencyDTO) {
		return EmergencyConverter.toDTO(this.emergencyDAO.readEmergency(EmergencyConverter.toEntity(emergencyDTO)));
	}
	
	public boolean updateEmergency(EmergencyDTO emergencyDTO) {
		return this.emergencyDAO.updateEmergency(EmergencyConverter.toEntity(emergencyDTO));
		
}
	
	public boolean deleteEmergencys (EmergencyDTO emergencyDTO) {
		return this.emergencyDAO.deleteEmergency(EmergencyConverter.toEntity(emergencyDTO));
		
}
	
	public boolean insertEmergencys (EmergencyDTO emergencysDTO) {
		return this.emergencyDAO.insertEmergency(EmergencyConverter.toEntity(emergencysDTO));
	
}
		
	
	
}
