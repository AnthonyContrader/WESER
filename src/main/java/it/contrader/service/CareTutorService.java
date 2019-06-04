package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterCareTutor;
import it.contrader.dao.CareTutorDAO;
import it.contrader.dto.CareTutorDTO;
import it.contrader.model.CareTutor;

public class CareTutorService {

	private CareTutorDAO careTutorDAO;

	public CareTutorService() {
		this.careTutorDAO = new CareTutorDAO();
	}

	public List<CareTutor> getAllCareTutor() {
		return this.careTutorDAO.getAllCareTutor();
	}

	public boolean insertCareTutor(CareTutorDTO careTutorDTO) {
		return this.careTutorDAO.insertCareTutor(ConverterCareTutor.toEntity(careTutorDTO));
	}
	
	public CareTutorDTO readCareTutor(int careTutorId) {
		return ConverterCareTutor.toDTO(this.careTutorDAO.readCareTutor(careTutorId));
	}
	
	public boolean updateCareTutor(CareTutorDTO careTutorDTO) {
		return this.careTutorDAO.updateCareTutor(ConverterCareTutor.toEntity(careTutorDTO));
	}
	
	public boolean deleteCareTutor(int careTutorId) {
		return this.careTutorDAO.deleteCareTutor(careTutorId);
	}
	
	
}
