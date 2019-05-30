package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CareDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Care;
import it.contrader.service.CareService;

public class CareController implements Controller {

	private static String sub_package = "care.";
	private CareService caresService;
	private Request request;

	public CareController() {
		this.caresService = new CareService();
	}

	public List<Care> getAllCare() {
		return this.caresService.getAllCare();
	}

	public CareDTO readCare(int careId) {
		return this.caresService.readCare(careId);
	}

	public boolean insertCare(CareDTO caresDTO) {
		return this.caresService.insertCare(caresDTO);
	}

	public boolean updateCare(CareDTO caresDTO) {
		return this.caresService.updateCare(caresDTO);
	}

	public boolean deleteCare(Integer caresId) {
		return this.caresService.deleteCare(caresId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Care", null);
		} else {
			switch (choice) {
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "CareRead", null);
				break;
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "CareInsert", null);
				break;
			case "3":
				MainDispatcher.getInstance().callView(sub_package + "CareUpdate", null);
				break;
			case "4":
				MainDispatcher.getInstance().callView(sub_package + "CareDelete", null);
				break;
			case "5":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
