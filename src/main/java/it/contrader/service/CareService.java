package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterCare;
import it.contrader.dao.CareDAO;
import it.contrader.dto.CareDTO;
import it.contrader.model.Care;

public class CareService {

	private CareDAO careDAO;

	public CareService() {
		this.careDAO = new CareDAO();
	}

	public List<Care> getAllCare() {
		return this.careDAO.getAllCare();
	}

	public boolean insertCare(CareDTO careDTO) {
		return this.careDAO.insertCare(ConverterCare.toEntity(careDTO));
	}
	
	public CareDTO readCare(int careId) {
		return ConverterCare.toDTO(this.careDAO.readCare(careId));
	}
	
	public boolean updateCare(CareDTO careDTO) {
		return this.careDAO.updateCare(ConverterCare.toEntity(careDTO));
	}
	
	public boolean deleteCare(int careId) {
		return this.careDAO.deleteCare(careId);
	}
	
	
}
