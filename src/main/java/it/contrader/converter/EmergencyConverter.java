package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.EmergencyDTO;

import it.contrader.model.Emergency;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class EmergencyConverter extends AbstractConverter<Emergency,EmergencyDTO> {

	@Override
	public Emergency toEntity(EmergencyDTO emergencyDTO) {
		Emergency emergency = null;
		if (emergencyDTO != null) {
			emergency = new Emergency(emergencyDTO.getId(),emergencyDTO.getNum());			
		}
		return emergency;
	}

	@Override
	public EmergencyDTO toDTO(Emergency emergency) {
		EmergencyDTO emergencyDTO = null;
		if (emergency != null) {
			emergencyDTO = new EmergencyDTO(emergency.getId(),emergency.getNum());
			
		}
		return emergencyDTO;
	}
}