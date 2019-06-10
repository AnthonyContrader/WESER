package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.ReadingConverter;
import it.contrader.dao.ReadingDAO;
import it.contrader.dto.ReadingDTO;
import it.contrader.model.Reading;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class ReadingServiceDTO {

	private final ReadingDAO readingDAO;

	public ReadingServiceDTO() {
		this.readingDAO = new ReadingDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<ReadingDTO> getAllReadings() {

		List<Reading> list = readingDAO.getAllReading();
		List<ReadingDTO> listDTO = new ArrayList<>();

		for (Reading reading : list) {
			listDTO.add(ReadingConverter.toDTO(reading));
		}

		return listDTO;
	}
	

	public ReadingDTO readReading(ReadingDTO readingDTO) {
		return ReadingConverter.toDTO(this.readingDAO.readReading(ReadingConverter.toEntity(readingDTO)));
	}
	
	
	public boolean deleteReadings (ReadingDTO readingDTO) {
		return this.readingDAO.deleteReading(ReadingConverter.toEntity(readingDTO));
		
}
	
	public boolean insertReadings (ReadingDTO readingsDTO) {
		return this.readingDAO.insertReading(ReadingConverter.toEntity(readingsDTO));
	
}
		
	
	
}
