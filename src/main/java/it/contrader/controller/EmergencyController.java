package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EmergencyDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Emergency;
import it.contrader.service.EmergencyService;

public class EmergencyController implements Controller {

	private static String sub_package = "emergency.";
	private EmergencyService emergencysService;
	private Request request;

	public EmergencyController() {
		this.emergencysService = new EmergencyService();
	}

	public List<Emergency> getAllEmergency() {
		return this.emergencysService.getAllEmergency();
	}

	public EmergencyDTO readEmergency(int Id_em) {
		return this.emergencysService.readEmergency(Id_em);
	}

	public boolean insertEmergency(EmergencyDTO emergencysDTO) {
		return this.emergencysService.insertEmergency(emergencysDTO);
	}

	public boolean updateEmergency(EmergencyDTO emergencysDTO) {
		return this.emergencysService.updateEmergency(emergencysDTO);
	}

	public boolean deleteEmergency(Integer emergencysId) {
		return this.emergencysService.deleteEmergency(emergencysId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Emergency", null);
		} else {
			switch (choice) {
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "EmergencyRead", null);
				break;
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "EmergencyInsert", null);
				break;
			case "3":
				MainDispatcher.getInstance().callView(sub_package + "EmergencyUpdate", null);
				break;
			case "4":
				MainDispatcher.getInstance().callView(sub_package + "EmergencyDelete", null);
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
