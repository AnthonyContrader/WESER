package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CareTutorDTO;
import it.contrader.model.CareTutor;

public class ConverterCareTutor {

	public static CareTutorDTO toDTO(CareTutor careTutor) {
		CareTutorDTO careTutorDTO = null;
		if (careTutor != null) {
			careTutorDTO = new CareTutorDTO();
			careTutorDTO.setCareTutorcareid(careTutor.getCareTutorcareid());
			careTutorDTO.setCareTutorpatname(careTutor.getCareTutorpatname());
			careTutorDTO.setCareTutorpatage(careTutor.getCareTutorpatage());
			careTutorDTO.setCareTutorpatcf(careTutor.getCareTutorpatcf());
			careTutorDTO.setCareTutorpatology(careTutor.getCareTutorpatology());
			careTutorDTO.setCareTutorquantity(careTutor.getCareTutorquantity());
			careTutorDTO.setCareTutornotes(careTutor.getCareTutornotes());
	
			
		}
		return careTutorDTO;
	}

	public static CareTutor toEntity(CareTutorDTO careTutorDTO) {
		CareTutor careTutor = null;
		if (careTutorDTO != null) {
		careTutor = new CareTutor();
			careTutor.setCareTutorcareid(careTutorDTO.getCareTutorcareid());
			careTutor.setCareTutorpatname(careTutorDTO.getCareTutorpatname());
			careTutor.setCareTutorpatcf(careTutorDTO.getCareTutorpatcf());
			careTutor.setCareTutorpatage(careTutorDTO.getCareTutorpatage());
			careTutor.setCareTutorpatology(careTutorDTO.getCareTutorpatology());
			careTutor.setCareTutorcarename(careTutorDTO.getCareTutorcarename());
			careTutor.setCareTutorquantity(careTutorDTO.getCareTutorquantity());
			careTutor.setCareTutornotes(careTutorDTO.getCareTutornotes());
			}
		return careTutor;
	}

	public static List<CareTutorDTO> toListDTO(List<CareTutor> list) {
		List<CareTutorDTO> listCareTutorDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (CareTutor careTutor : list) {
				listCareTutorDTO.add(ConverterCareTutor.toDTO(careTutor));
			}
		}
		return listCareTutorDTO;
	}

	public static List<CareTutor> toListEntity(List<CareTutorDTO> listCareTutorDTO) {
		List<CareTutor> list = new ArrayList<>();
		if (!listCareTutorDTO.isEmpty()) {
			for (CareTutorDTO careTutorDTO : listCareTutorDTO) {
				list.add(ConverterCareTutor.toEntity(careTutorDTO));
			}
		}
		return list;
	}
}
