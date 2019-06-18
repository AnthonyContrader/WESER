package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.PatologyRepository;
import it.contrader.dto.PatologyDTO;
import it.contrader.model.Patology;

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
public class PatologyService extends AbstractService<Patology,PatologyDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public PatologyDTO findById(int id) {
		return converter.toDTO(((PatologyRepository)repository).findById(id));
	}

}
