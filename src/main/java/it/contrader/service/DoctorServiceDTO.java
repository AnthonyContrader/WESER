package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.DoctorConverter;
import it.contrader.dao.DoctorDAO;
import it.contrader.dto.DoctorDTO;
import it.contrader.model.Doctor;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class DoctorServiceDTO {

	private final DoctorDAO doctorDAO;

	public DoctorServiceDTO() {
		this.doctorDAO = new DoctorDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<DoctorDTO> getAllDoctors() {

		List<Doctor> list = doctorDAO.getAllDoctor();
		List<DoctorDTO> listDTO = new ArrayList<>();

		for (Doctor doctor : list) {
			listDTO.add(DoctorConverter.toDTO(doctor));
		}

		return listDTO;
	}
	

	public DoctorDTO readDoctor(DoctorDTO doctorDTO) {
		return DoctorConverter.toDTO(this.doctorDAO.readDoctor(DoctorConverter.toEntity(doctorDTO)));
	}
	
	public boolean updateDoctor(DoctorDTO doctorDTO) {
		return this.doctorDAO.updateDoctor(DoctorConverter.toEntity(doctorDTO));
		
}
	
	public boolean deleteDoctors (DoctorDTO doctorDTO) {
		return this.doctorDAO.deleteDoctor(DoctorConverter.toEntity(doctorDTO));
		
}
	
	public boolean insertDoctors (DoctorDTO doctorsDTO) {
		return this.doctorDAO.insertDoctor(DoctorConverter.toEntity(doctorsDTO));
	
}
		
	
	
}
