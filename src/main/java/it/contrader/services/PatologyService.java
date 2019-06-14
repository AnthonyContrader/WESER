package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterPatology;
import it.contrader.dao.PatologyRepository;
import it.contrader.dto.PatologyDTO;
import it.contrader.model.Patology;

@Service
public class PatologyService {

	private final PatologyRepository patologyRepository;

	@Autowired
	public PatologyService(PatologyRepository patologyRepository) {
		this.patologyRepository = patologyRepository;
	}

	public List<PatologyDTO> getListaPatologyDTO() {
		return ConverterPatology.toListDTO((List<Patology>) patologyRepository.findAll());
	}

	public PatologyDTO getPatologyDTOById(Integer id) {
		return ConverterPatology.toDTO(patologyRepository.findById(id).get());
	}


	public boolean insertPatology(PatologyDTO patologyDTO) {
		return patologyRepository.save(ConverterPatology.toEntity(patologyDTO)) != null;
	}

	public boolean updatePatology(PatologyDTO patologyDTO) {
		return patologyRepository.save(ConverterPatology.toEntity(patologyDTO)) != null;
	}
	
	public void deletePatologyById(Integer id) {
		patologyRepository.deleteById(id);
	}
	
	public List<PatologyDTO> findAllPatologyDTO() {
		
		final List<Patology> list = (List<Patology>) patologyRepository.findAll();
		final List<PatologyDTO> patologyDTOs = new ArrayList<>();
		list.forEach(i -> patologyDTOs.add(ConverterPatology.toDTO(i)));
		return patologyDTOs;
		
	
	}

}
