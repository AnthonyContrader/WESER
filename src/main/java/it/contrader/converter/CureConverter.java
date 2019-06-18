package it.contrader.converter;

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

	@Override
	public Cure toEntity(CureDTO cureDTO) {
		Cure cure = null;
		if (cureDTO != null) {
			cure = new Cure(cureDTO.getId(),cureDTO.getCf(),cureDTO.getAge(),cureDTO.getPato(),cureDTO.getName(),cureDTO.getQuantity(),cureDTO.getNotes());			
		}
		return cure;
	}

	@Override
	public CureDTO toDTO(Cure cure) {
		CureDTO cureDTO = null;
		if (cure != null) {
			cureDTO = new CureDTO(cure.getId(),cure.getCf(),cure.getAge(),cure.getPato(),cure.getName(),cure.getQuantity(),cure.getNotes());
			
		}
		return cureDTO;
	}
}