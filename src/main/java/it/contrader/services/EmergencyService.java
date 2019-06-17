package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterEmergency;
import it.contrader.dao.EmergencyRepository;
import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;

@Service
public class EmergencyService {

	private final EmergencyRepository emergencyRepository;

	@Autowired
	public EmergencyService(EmergencyRepository emergencyRepository) {
		this.emergencyRepository = emergencyRepository;
	}

	public List<EmergencyDTO> getListaEmergencyDTO() {
		return ConverterEmergency.toListDTO((List<Emergency>) emergencyRepository.findAll());
	}

	public EmergencyDTO getEmergencyDTOById(Integer id) {
		return ConverterEmergency.toDTO(emergencyRepository.findById(id).get());
	}


	public boolean insertEmergency(EmergencyDTO emergencyDTO) {
		return emergencyRepository.save(ConverterEmergency.toEntity(emergencyDTO)) != null;
	}

	public boolean updateEmergency(EmergencyDTO emergencyDTO) {
		return emergencyRepository.save(ConverterEmergency.toEntity(emergencyDTO)) != null;
	}
	
	public void deleteEmergencyById(Integer id) {
		emergencyRepository.deleteById(id);
	}
	
	public List<EmergencyDTO> findAllEmergencyDTO() {
		
		final List<Emergency> list = (List<Emergency>) emergencyRepository.findAll();
		final List<EmergencyDTO> emergencyDTOs = new ArrayList<>();
		list.forEach(i -> emergencyDTOs.add(ConverterEmergency.toDTO(i)));
		return emergencyDTOs;
		
	
	}

}
