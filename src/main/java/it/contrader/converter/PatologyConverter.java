package it.contrader.converter;


import it.contrader.dto.PatologyDTO;
import it.contrader.model.Patology;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class PatologyConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Patology toEntity(PatologyDTO patologyDTO) {

		Patology patology = null;
		if (patologyDTO != null) {
			patology = new Patology(patologyDTO.getPatology(),patologyDTO.getCarename(),patologyDTO.getQuantity(),patologyDTO.getPatcf(),patologyDTO.getPatominpress(),patologyDTO.getPatomaxpress(),patologyDTO.getPatomincir(),patologyDTO.getPatomaxcir(),patologyDTO.getPatominbreath(),patologyDTO.getPatomaxbreath(),patologyDTO.getPatomintemp(),patologyDTO.getPatomaxtemp());
			if (patologyDTO.getPatologyid() != 0)
				patology.setPatologyid(patologyDTO.getPatologyid());
		}
		
		return patology;
	}
	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static PatologyDTO toDTO(Patology patology) {

		PatologyDTO patologyDTO = null;
		if (patology != null) {
			patologyDTO = new PatologyDTO(patology.getPatology(),patology.getCarename(),patology.getQuantity(),patology.getPatcf(),patology.getPatominpress(),patology.getPatomaxpress(),patology.getPatomincir(),patology.getPatomaxcir(),patology.getPatominbreath(),patology.getPatomaxbreath(),patology.getPatomintemp(),patology.getPatomaxtemp());
			patologyDTO.setPatologyid(patology.getPatologyid());
			
			// patologyDTO.setId(patology.getPatologyId());
		}

		return patologyDTO;
	}

}