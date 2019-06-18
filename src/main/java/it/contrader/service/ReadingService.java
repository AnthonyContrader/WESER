package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ReadingRepository;
import it.contrader.dto.ReadingDTO;
import it.contrader.model.Reading;

/**
 * Estende AbstractService con parametri Reading e ReadingDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class ReadingService extends AbstractService<Reading,ReadingDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public ReadingDTO findBId(int id) {
		return converter.toDTO(((ReadingRepository)repository).findById(id));
	}

}
