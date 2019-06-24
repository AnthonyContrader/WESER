package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CureConverter;
import it.contrader.dao.CureRepository;
import it.contrader.dto.CureDTO;
import it.contrader.model.Cure;

/**
 * Estende AbstractService con parametri Cure e CureDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class CureService extends AbstractService<Cure,CureDTO> {
	
	//ALL crud methods in AbstractService
	@Autowired
	CureRepository asd ;
	@Autowired
	CureConverter xkcd;
	//LOGIN method
	public CureDTO findById(int id) {
		return converter.toDTO(((CureRepository)repository).findById(id));
	}
	public Iterable<CureDTO> getTutto () {
		return xkcd.toDTOList(asd.findAll());
		
	}

}
