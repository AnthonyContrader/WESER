package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EmergencyDTO;
import it.contrader.model.Emergency;

public class ConverterEmergency {

	public static EmergencyDTO toDTO(Emergency emergency) {
		EmergencyDTO emergencyDTO = null;
		if (emergency != null) {
			emergencyDTO = new EmergencyDTO();
			emergencyDTO.setId(emergency.getId());
			emergencyDTO.setNum(emergency.getNum());
		}
		return emergencyDTO;
	}

	public static Emergency toEntity(EmergencyDTO emergencyDTO) {
		Emergency emergency = null;
		if (emergencyDTO != null) {
			emergency = new Emergency();
			emergency.setId(emergencyDTO.getId());
			emergency.setNum(emergencyDTO.getNum());
		
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
