package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.CareTutorController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.CareTutor;

public class CareTutorView implements View {

	private CareTutorController caresTutorController;
	private Request request;
	private String choice;
	
	public CareTutorView() {
		this.caresTutorController = new CareTutorController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n CARE TUTOR VIEW \n");
		System.out.println("ID\t Patient name\t Patient SSC\t Patient age\t Patology\t Care name\t Quantity\t Notes");
		System.out.print("------------------------------------------------------");
		List<CareTutor> cares = caresTutorController.getAllCareTutor();
		System.out.println();
		cares.forEach(care -> System.out.println(care.toString()));
		System.out.println();
		
		
		System.out.println("[1] Return to login");
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
		    MainDispatcher.getInstance().callAction("Care", "doControl", this.request);
	}

}
