package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EmergencyDTO;
import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;
import it.contrader.model.Emergency;

public class ConverterEmergency {

	public static EmergencyDTO toDTO(Emergency emergency) {
		EmergencyDTO emergencyDTO = null;
		if (emergency != null) {
			emergencyDTO = new EmergencyDTO();
			emergencyDTO.setIdem(emergency.getIdem());
			emergencyDTO.setEmnum(emergency.getEmnum());
		}
		return emergencyDTO;
	}

	public static Emergency toEntity(EmergencyDTO emergencyDTO) {
		Emergency emergency = null;
		if (emergencyDTO != null) {
			emergency = new Emergency();
			emergency.setIdem(emergencyDTO.getIdem());
			emergency.setEmnum(emergencyDTO.getEmnum());
		}
		return emergency;
	}

	public static List<EmergencyDTO> toListDTO(List<Emergency> list) {
		List<EmergencyDTO> listEmergencyDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Emergency emergency : list) {
				listEmergencyDTO.add(ConverterEmergency.toDTO(emergency));
			}
		}
		return listEmergencyDTO;
	}

	public static List<Emergency> toListEntity(List<EmergencyDTO> listEmergencyDTO) {
		List<Emergency> list = new ArrayList<>();
		if (!listEmergencyDTO.isEmpty()) {
			for (EmergencyDTO emergencyDTO : listEmergencyDTO) {
				list.add(ConverterEmergency.toEntity(emergencyDTO));
			}
		}
		return list;
	}
}
