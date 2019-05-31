package it.contrader.view.emergency;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.EmergencyController;
import it.contrader.dto.EmergencyDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Emergency;
import it.contrader.view.View;

public class EmergencyReadView implements View {

	private EmergencyController emergencysController;
	private Request request;

	public EmergencyReadView() {
		this.emergencysController = new EmergencyController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int Id_emToRead;

		System.out.println("Insert emergency ID ");

		try {
			Id_emToRead = Integer.parseInt(getInput());
			EmergencyDTO emergencyDB = emergencysController.readEmergency(Id_emToRead);

			System.out.println("Id: " + emergencyDB.getId_em());
			System.out.println("Emergency number: " + emergencyDB.getEm_num());
			
			//Wait emergency to show
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
		MainDispatcher.getInstance().callAction("Emergency", "doControl", request);
	}

}
