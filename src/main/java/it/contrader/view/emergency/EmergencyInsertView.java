package it.contrader.view.emergency;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.EmergencyController;
import it.contrader.dto.EmergencyDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class EmergencyInsertView implements View {

	private EmergencyController emergencysController;
	private Request request;

	public EmergencyInsertView() {
		this.emergencysController = new EmergencyController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String em_num;

		System.out.println("Insert emergency number");
		em_num = getInput();
		
		
		
		if (!em_num.equals("")) {
			emergencysController.insertEmergency(new EmergencyDTO(em_num));
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
	
	public float getFloat() {
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
