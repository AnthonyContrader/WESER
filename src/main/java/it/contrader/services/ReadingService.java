package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterReading;
import it.contrader.dao.ReadingRepository;
import it.contrader.dto.ReadingDTO;
import it.contrader.model.Reading;

@Service
public class ReadingService {

	private final ReadingRepository readingRepository;

	@Autowired
	public ReadingService(ReadingRepository readingRepository) {
		this.readingRepository = readingRepository;
	}

	public List<ReadingDTO> getListaReadingDTO() {
		return ConverterReading.toListDTO((List<Reading>) readingRepository.findAll());
	}

	public ReadingDTO getReadingDTOById(Integer id) {
		return ConverterReading.toDTO(readingRepository.findById(id).get());
	}

	public boolean insertReading(ReadingDTO readingDTO) {
		return readingRepository.save(ConverterReading.toEntity(readingDTO)) != null;
	}

//	public boolean updateReading(ReadingDTO readingDTO) {
//		return readingRepository.save(ConverterReading.toEntity(readingDTO)) != null;
//	}
	
	public void deleteReadingById(Integer id) {
		readingRepository.deleteById(id);
	}
	
	public List<ReadingDTO> findAllReadingByPatcf(String patcf) {
		
		final List<Reading> list = readingRepository.findAllByPatcf(patcf);
		final List<ReadingDTO> readingDTOs = new ArrayList<>();
		list.forEach(i -> readingDTOs.add(ConverterReading.toDTO(i)));
		return readingDTOs;
		
	
	}
}

