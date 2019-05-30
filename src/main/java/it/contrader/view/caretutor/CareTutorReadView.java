package it.contrader.view.caretutor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.CareTutorController;
import it.contrader.dto.CareTutorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.CareTutor;
import it.contrader.view.View;

public class CareTutorReadView implements View {

	private CareTutorController careTutorsController;
	private Request request;

	public CareTutorReadView() {
		this.careTutorsController = new CareTutorController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int careTutorIdToRead;

		System.out.println("Insert careTutor ID ");

		try {
			careTutorIdToRead = Integer.parseInt(getInput());
			CareTutorDTO careTutorDB = careTutorsController.readCareTutor(careTutorIdToRead);

			System.out.println("Id: " + careTutorDB.getCareTutorcareid());
			System.out.println("Patient name: " + careTutorDB.getCareTutorpatname());
			System.out.println("Patient SSC: " + careTutorDB.getCareTutorpatcf());
			System.out.println("Patient age: " + careTutorDB.getCareTutorpatage());
			System.out.println("Patology: " + careTutorDB.getCareTutorpatology());
			System.out.println("Care name: " + careTutorDB.getCareTutorcarename());
			System.out.println("Quantity: " + careTutorDB.getCareTutorquantity());
			System.out.println("Notes: " + careTutorDB.getCareTutornotes());
			
			
			//Wait careTutor to show
			System.out.println("Press any key to continue");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Incorect entry");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("CareTutor", "doControl", request);
	}

}
