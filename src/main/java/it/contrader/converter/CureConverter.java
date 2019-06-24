package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.CureDTO;
import it.contrader.model.Cure;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class CureConverter extends AbstractConverter<Cure,CureDTO> {
 @Autowired
 private PatologyConverter converter;
 @Autowired
 private ReadingConverter converterR;
 
	@Override
	public Cure toEntity(CureDTO cureDTO) {
		Cure cure = null;
		if (cureDTO != null) {
			cure = new Cure();		
			cure.setId(cureDTO.getId());
			if(cureDTO.getReadingDTO()!= null) {
				cure.setReading(converterR.toEntity(cureDTO.getReadingDTO()));
			}
			cure.setAge(cureDTO.getAge());
			if(cureDTO.getPatologyDTO()!= null) {
				cure.setPatology(converter.toEntity(cureDTO.getPatologyDTO()));
			}
			cure.setName(cureDTO.getName());
			cure.setDosage(cureDTO.getDosage());
			cure.setPosology(cureDTO.getPosology());
			cure.setNotes(cureDTO.getNotes());
		
		}
		return cure;
	}

	@Override
	public CureDTO toDTO(Cure cure) {
		CureDTO cureDTO = null;
		if (cure != null) {
			cureDTO = new CureDTO();
			cureDTO.setId(cure.getId());
			if(cure.getReading()!= null) {
				cureDTO.setReadingDTO(converterR.toDTO(cure.getReading()));
			}
			cureDTO.setAge(cure.getAge());
			if(cure.getPatology()!= null) {
				cureDTO.setPatologyDTO(converter.toDTO(cure.getPatology()));
			}
			cureDTO.setName(cure.getName());
			cureDTO.setDosage(cure.getDosage());
			cureDTO.setPosology(cure.getPosology());
			cureDTO.setNotes(cure.getNotes());
			
		}
		return cureDTO;
	}
}
	