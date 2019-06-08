package it.contrader.converter;

import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class EmergencyConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Emergency toEntity(EmergencyDTO emergencyDTO) {

		Emergency emergency = null;
		if (emergencyDTO != null) {
			emergency = new Emergency(emergencyDTO.getEmnum());

			if (emergencyDTO.getEmId() != null)
				emergency.setEmId(emergencyDTO.getEmId());
		}
		
		
		return emergency;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static EmergencyDTO toDTO(Emergency emergency) {

		EmergencyDTO emergencyDTO = null;
		if (emergency != null) {
			emergencyDTO = new EmergencyDTO(emergency.getEmnum());
			emergencyDTO.setEmId(emergency.getEmId());
		}

		return emergencyDTO;
	}

}