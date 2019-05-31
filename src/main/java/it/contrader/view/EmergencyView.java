package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.EmergencyController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Emergency;

public class EmergencyView implements View {

	private EmergencyController emergencysController;
	private Request request;
	private String choice;
	
	public EmergencyView() {
		this.emergencysController = new EmergencyController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n EMERGENCY NUMBER MENU \n");
		System.out.println("ID\t Emergency number");
		System.out.print("------------------------------------------------------");
		List<Emergency> emergencys = emergencysController.getAllEmergency();
		System.out.println();
		emergencys.forEach(emergency -> System.out.println(emergency.toString()));
		System.out.println();
		
		System.out.println("Choose operation");
		System.out.println("[1] Emergency number view");
		System.out.println("[2] Insert new number");
		System.out.println("[3] Update existing number");
		System.out.println("[4] Delete existing number");
		System.out.println("[5] Return to login");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Emergency", "doControl", this.request);
	}

}
