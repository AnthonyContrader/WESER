package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PatologyDTO;

import it.contrader.model.Patology;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class PatologyConverter extends AbstractConverter<Patology,PatologyDTO> {

	@Override
	public Patology toEntity(PatologyDTO patologyDTO) {
		Patology patology = null;
		if (patologyDTO != null) {
			patology = new Patology(patologyDTO.getId(),patologyDTO.getPato(),patologyDTO.getCarename(),patologyDTO.getCf(),patologyDTO.getQuantity(),patologyDTO.getMp(),patologyDTO.getMpr(),patologyDTO.getMc(),patologyDTO.getMci(),patologyDTO.getMb(),patologyDTO.getMbr(),patologyDTO.getMt(),patologyDTO.getMte(),patologyDTO.getNotes());			
		}
		return patology;
	}

	@Override
	public PatologyDTO toDTO(Patology patology) {
		PatologyDTO patologyDTO = null;
		if (patology != null) {
			patologyDTO = new PatologyDTO(patology.getId(),patology.getPato(),patology.getCarename(),patology.getCf(),patology.getQuantity(),patology.getMp(),patology.getMpr(),patology.getMc(),patology.getMci(),patology.getMb(),patology.getMbr(),patology.getMt(),patology.getMte(),patology.getNotes());			
		}
		return patologyDTO;
	}
}