package it.contrader.converter;

import it.contrader.dto.DoctorDTO;
import it.contrader.model.Doctor;
import it.contrader.model.User;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class DoctorConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Doctor toEntity(DoctorDTO doctorDTO) {

		Doctor doctor = null;
		if (doctorDTO != null) {
			doctor = new Doctor(doctorDTO.getPatname(),doctorDTO.getPatcf(),doctorDTO.getPatage(),doctorDTO.getPatology(),doctorDTO.getCarename(),doctorDTO.getQuantity(),doctorDTO.getNotes());
			if (doctorDTO.getCareid() != 0)
				doctor.setCareid(doctorDTO.getCareid());
		}
		
		return doctor;
	}
	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static DoctorDTO toDTO(Doctor doctor) {

		DoctorDTO doctorDTO = null;
		if (doctor != null) {
			doctorDTO = new DoctorDTO(doctor.getParname(),doctor.getPatcf(),doctor.getPatage(),doctor.getPatology(),doctor.getCarename(),doctor.getQuantity(),doctor.getNotes());
			doctorDTO.setCareid(doctor.getCareid());
			
			// doctorDTO.setId(doctor.getDoctorId());
		}

		return doctorDTO;
	}

}