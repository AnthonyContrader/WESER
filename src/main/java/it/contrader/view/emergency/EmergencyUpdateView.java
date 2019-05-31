package it.contrader.view.emergency;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.EmergencyController;
import it.contrader.dto.EmergencyDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class EmergencyUpdateView implements View {

	private EmergencyController emergencysController;
	private Request request;

	public EmergencyUpdateView() {
		this.emergencysController = new EmergencyController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int Id_emToUpdate;
		String em_num;
		
		/*
		 * List<Emergency> emergencys; Integer emergencysId; String password; emergencys =
		 * emergencysController.getAllEmergencys();
		 */
		System.out.println("\nEmergency update\n");
		// System.out.println();
		// emergencys.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		EmergencyDTO emergencyDTO = new EmergencyDTO();

		System.out.println("Insert the emergency ID to update");
		try {
			Id_emToUpdate = Integer.parseInt(getInput());
			if (Id_emToUpdate != 0) {
				emergencyDTO.setId_em(Id_emToUpdate);

				System.out.println("Insert new emergency number:");
				em_num = getInput();
				if (!em_num.equals(""))
					emergencyDTO.setEm_num(em_num);
				emergencysController.updateEmergency(emergencyDTO);

			}
		} catch (Exception e) {
			System.out.println("Incorrect entry");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}
	
	public int getInt() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public Float getFloat() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextFloat();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Emergency", "doControl", request);
	}

}
