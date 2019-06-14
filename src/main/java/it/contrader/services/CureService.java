package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCure;
import it.contrader.dao.CureRepository;
import it.contrader.dto.CureDTO;
import it.contrader.model.Cure;

@Service
public class CureService {

	private final CureRepository cureRepository;

	@Autowired
	public CureService(CureRepository cureRepository) {
		this.cureRepository = cureRepository;
	}

	public List<CureDTO> getListaCureDTO() {
		return ConverterCure.toListDTO((List<Cure>) cureRepository.findAll());
	}

	public CureDTO getCureDTOById(Integer id) {
		return ConverterCure.toDTO(cureRepository.findById(id).get());
	}

	public boolean insertCure(CureDTO cureDTO) {
		return cureRepository.save(ConverterCure.toEntity(cureDTO)) != null;
	}

	public boolean updateCure(CureDTO cureDTO) {
		return cureRepository.save(ConverterCure.toEntity(cureDTO)) != null;
	}
	
	public void deleteCureById(Integer id) {
		cureRepository.deleteById(id);
	}
	
	public List<CureDTO> findAllCureDTO(String curename) {
		
		final List<Cure> list = cureRepository.findAllByCurename(curename);
		final List<CureDTO> cureDTOs = new ArrayList<>();
		list.forEach(i -> cureDTOs.add(ConverterCure.toDTO(i)));
		return cureDTOs;
		
	
	}

}
