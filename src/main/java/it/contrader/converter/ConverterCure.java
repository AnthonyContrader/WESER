package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CureDTO;
import it.contrader.model.Cure;

public class ConverterCure {

	public static CureDTO toDTO(Cure cure) {
		CureDTO cureDTO = null;
		if (cure != null) {
			cureDTO = new CureDTO();
			cureDTO.setIdcure(cure.getIdcure());
			cureDTO.setPatname(cure.getPatname());
			cureDTO.setPatage(cure.getPatage());
			cureDTO.setPato(cure.getPato());
			cureDTO.setCarename(cure.getCarename());
			cureDTO.setQuantity(cure.getQuantity());
			cureDTO.setNotes(cure.getNotes());
		}
		return cureDTO;
	}

	public static Cure toEntity(CureDTO cureDTO) {
		Cure cure = null;
		if (cureDTO != null) {
			cure = new Cure();
			cure.setIdcure(cureDTO.getIdcure());
			cure.setPatname(cureDTO.getPatname());
			cure.setPatage(cureDTO.getPatage());
			cure.setPato(cureDTO.getPato());
			cure.setCarename(cureDTO.getCarename());
			cure.setQuantity(cureDTO.getQuantity());
			cure.setNotes(cureDTO.getNotes());
		}
		return cure;
	}

	public static List<CureDTO> toListDTO(List<Cure> list) {
		List<CureDTO> listCureDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Cure cure : list) {
				listCureDTO.add(ConverterCure.toDTO(cure));
			}
		}
		return listCureDTO;
	}

	public static List<Cure> toListEntity(List<CureDTO> listCureDTO) {
		List<Cure> list = new ArrayList<>();
		if (!listCureDTO.isEmpty()) {
			for (CureDTO cureDTO : listCureDTO) {
				list.add(ConverterCure.toEntity(cureDTO));
			}
		}
		return list;
	}
}
