package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CareDTO;
import it.contrader.model.Care;

public class ConverterCare {

	public static CareDTO toDTO(Care care) {
		CareDTO careDTO = null;
		if (care != null) {
			careDTO = new CareDTO();
			careDTO.setCareId(care.getCareId());
			careDTO.setPatname(care.getPatname());
			careDTO.setPatcf(care.getPatcf());
			careDTO.setPatage(care.getPatage());
			careDTO.setPatology(care.getPatology());
			careDTO.setCarename(care.getCarename());
			careDTO.setQuantity(care.getQuantity());
			careDTO.setNotes(care.getNotes());
		}
		return careDTO;
	}

	public static Care toEntity(CareDTO careDTO) {
		Care care = null;
		if (careDTO != null) {
			care = new Care();
			care.setCareId(careDTO.getCareId());
			care.setPatname(careDTO.getPatname());
			care.setPatcf(careDTO.getPatcf());
			care.setPatage(careDTO.getPatage());
			care.setPatology(careDTO.getPatology());
			care.setCarename(careDTO.getCarename());
			care.setQuantity(careDTO.getQuantity());
			care.setNotes(careDTO.getNotes());
		}
		return care;
	}

	public static List<CareDTO> toListDTO(List<Care> list) {
		List<CareDTO> listCareDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Care care : list) {
				listCareDTO.add(ConverterCare.toDTO(care));
			}
		}
		return listCareDTO;
	}

	public static List<Care> toListEntity(List<CareDTO> listCareDTO) {
		List<Care> list = new ArrayList<>();
		if (!listCareDTO.isEmpty()) {
			for (CareDTO careDTO : listCareDTO) {
				list.add(ConverterCare.toEntity(careDTO));
			}
		}
		return list;
	}
}
