package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.EmergencyRepository;
import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class EmergencyService extends AbstractService<Emergency,EmergencyDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public EmergencyDTO findById(int id) {
		return converter.toDTO(((EmergencyRepository)repository).findById(id));
	}

}
