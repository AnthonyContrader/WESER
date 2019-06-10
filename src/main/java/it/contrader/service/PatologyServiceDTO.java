package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.PatologyConverter;
import it.contrader.dao.PatologyDAO;
import it.contrader.dto.PatologyDTO;
import it.contrader.model.Patology;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class PatologyServiceDTO {

	private final PatologyDAO patologyDAO;

	public PatologyServiceDTO() {
		this.patologyDAO = new PatologyDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<PatologyDTO> getAllPatologys() {

		List<Patology> list = patologyDAO.getAllPatology();
		List<PatologyDTO> listDTO = new ArrayList<>();

		for (Patology patology : list) {
			listDTO.add(PatologyConverter.toDTO(patology));
		}

		return listDTO;
	}
	

	public PatologyDTO readPatology(PatologyDTO patologyDTO) {
		return PatologyConverter.toDTO(this.patologyDAO.readPatology(PatologyConverter.toEntity(patologyDTO)));
	}
	
	public boolean updatePatology(PatologyDTO patologyDTO) {
		return this.patologyDAO.updatePatology(PatologyConverter.toEntity(patologyDTO));
		
}
	
	public boolean deletePatologys (PatologyDTO patologyDTO) {
		return this.patologyDAO.deletePatology(PatologyConverter.toEntity(patologyDTO));
		
}
	
	public boolean insertPatologys (PatologyDTO patologysDTO) {
		return this.patologyDAO.insertPatology(PatologyConverter.toEntity(patologysDTO));
	
}
		
	
	
}
