package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PatologyDTO;
import it.contrader.model.Patology;

public class ConverterPatology {

	public static PatologyDTO toDTO(Patology patology) {
		PatologyDTO patologyDTO = null;
		if (patology != null) {
			patologyDTO = new PatologyDTO();
			patologyDTO.setIdpato(patology.getIdpato());
			patologyDTO.setPato(patology.getPato());
			patologyDTO.setCarename(patology.getCarename());
			patologyDTO.setPatcf(patology.getPatcf());
			patologyDTO.setQuantity(patology.getQuantity());
			patologyDTO.setPatominpress(patology.getPatominpress());
			patologyDTO.setPatomaxpress(patology.getPatomaxpress());
			patologyDTO.setPatomincir(patology.getPatomincir());
			patologyDTO.setPatomaxcir(patology.getPatomaxcir());
			patologyDTO.setPatominbreath(patology.getPatominbreath());
			patologyDTO.setPatomaxbreath(patology.getPatomaxbreath());
			patologyDTO.setPatomintemp(patology.getPatomintemp());
			patologyDTO.setPatomaxtemp(patology.getPatomaxtemp());
		}
		return patologyDTO;
	}

	public static Patology toEntity(PatologyDTO patologyDTO) {
		Patology patology = null;
		if (patologyDTO != null) {
			patology = new Patology();
			patology.setIdpato(patologyDTO.getIdpato());
			patology.setPato(patologyDTO.getPato());
			patology.setCarename(patologyDTO.getCarename());
			patology.setPatcf(patologyDTO.getPatcf());
			patology.setQuantity(patologyDTO.getQuantity());
			patology.setPatominpress(patologyDTO.getPatominpress());
			patology.setPatomaxpress(patologyDTO.getPatomaxpress());
			patology.setPatomincir(patologyDTO.getPatomincir());
			patology.setPatomaxcir(patologyDTO.getPatomaxcir());
			patology.setPatominbreath(patologyDTO.getPatominbreath());
			patology.setPatomaxbreath(patologyDTO.getPatomaxbreath());
			patology.setPatomintemp(patologyDTO.getPatomintemp());
			patology.setPatomaxtemp(patologyDTO.getPatomaxtemp());
		}
		return patology;
	}

	public static List<PatologyDTO> toListDTO(List<Patology> list) {
		List<PatologyDTO> listPatologyDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Patology patology : list) {
				listPatologyDTO.add(ConverterPatology.toDTO(patology));
			}
		}
		return listPatologyDTO;
	}

	public static List<Patology> toListEntity(List<PatologyDTO> listPatologyDTO) {
		List<Patology> list = new ArrayList<>();
		if (!listPatologyDTO.isEmpty()) {
			for (PatologyDTO patologyDTO : listPatologyDTO) {
				list.add(ConverterPatology.toEntity(patologyDTO));
			}
		}
		return list;
	}
}
