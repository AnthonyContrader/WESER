package it.contrader.converter;

import it.contrader.dto.ReadingDTO;
import it.contrader.model.Reading;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class ReadingConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Reading toEntity(ReadingDTO readingDTO) {

		Reading reading = null;
		if (readingDTO != null) {
			reading = new Reading(readingDTO.getPatcf(),readingDTO.getRegdev(),readingDTO.getMinpress(),readingDTO.getMaxpress(),readingDTO.getMincir(),readingDTO.getMaxcir(),readingDTO.getMinbreath(),readingDTO.getMaxbreath(),readingDTO.getMintemp(),readingDTO.getMaxtemp());

			if (readingDTO.getReadId() != 0)
				reading.setReadId(readingDTO.getReadId());
		}
		
		
		return reading;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static ReadingDTO toDTO(Reading reading) {

		ReadingDTO readingDTO = null;
		if (reading != null) {
			readingDTO = new ReadingDTO(reading.getPatcf(),reading.getRegdev(),reading.getMinpress(),reading.getMaxpress(),reading.getMincir(),reading.getMaxcir(),reading.getMinbreath(),reading.getMaxbreath(),reading.getMintemp(),reading.getMaxtemp());
			readingDTO.setReadId(reading.getReadId());
		}

		return readingDTO;
	}

}