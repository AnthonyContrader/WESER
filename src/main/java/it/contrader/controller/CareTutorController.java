package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CareTutorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.CareTutor;
import it.contrader.service.CareTutorService;

public class CareTutorController implements Controller {

	private static String sub_package = "careTutor.";
	private CareTutorService caresTutorService;
	private Request request;

	public CareTutorController() {
		this.caresTutorService = new CareTutorService();
	}

	public List<CareTutor> getAllCareTutor() {
		return this.caresTutorService.getAllCareTutor();
	}

	public CareTutorDTO readCareTutor(int careTutorId) {
		return this.caresTutorService.readCareTutor(careTutorId);
	}

	public boolean insertCareTutor(CareTutorDTO caresTutorDTO) {
		return this.caresTutorService.insertCareTutor(caresTutorDTO);
	}

	public boolean updateCareTutor(CareTutorDTO caresTutorDTO) {
		return this.caresTutorService.updateCareTutor(caresTutorDTO);
	}

	public boolean deleteCareTutor(Integer caresTutorId) {
		return this.caresTutorService.deleteCareTutor(caresTutorId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("CareTutor", null);
		} else {
			switch (choice) {
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "readCareTutor", null);
				break;
			
			case "2":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
