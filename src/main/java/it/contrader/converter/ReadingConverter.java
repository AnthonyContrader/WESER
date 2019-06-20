package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ReadingDTO;
import it.contrader.model.Reading;


/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class ReadingConverter extends AbstractConverter<Reading,ReadingDTO> {

	@Override
	public Reading toEntity(ReadingDTO readingDTO) {
		Reading reading = null;
		if (readingDTO != null) {
			reading = new Reading(readingDTO.getId(),readingDTO.getCf(),readingDTO.getRd(),readingDTO.getMp(),readingDTO.getMpr(),readingDTO.getCir(),readingDTO.getBre(),readingDTO.getTemp(),readingDTO.getDataora());			
		}
		return reading;
	}

	@Override
	public ReadingDTO toDTO(Reading reading) {
		ReadingDTO readingDTO = null;
		if (reading != null) {
			readingDTO = new ReadingDTO(reading.getId(),reading.getCf(),reading.getRd(),reading.getMp(),reading.getMpr(),reading.getCir(),reading.getBre(),reading.getTemp(),reading.getDataora());
			
		}
		return readingDTO;
	}
}