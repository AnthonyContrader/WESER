package it.contrader.view.care;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.CareController;
import it.contrader.dto.CareDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Care;
import it.contrader.view.View;

public class CareReadView implements View {

	private CareController caresController;
	private Request request;

	public CareReadView() {
		this.caresController = new CareController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int careIdToRead;

		System.out.println("Insert care ID ");

		try {
			careIdToRead = Integer.parseInt(getInput());
			CareDTO careDB = caresController.readCare(careIdToRead);

			System.out.println("Id: " + careDB.getCareId());
			System.out.println("Patient name: " + careDB.getPatname());
			System.out.println("Patient Social Security Code: " + careDB.getPatcf());
			System.out.println("Patient age: " + careDB.getPatage());
			System.out.println("Patology: " + careDB.getPatology());
			System.out.println("Care name: " + careDB.getCarename());
			System.out.println("Quantity: " + careDB.getQuantity());
			System.out.println("Notes: " + careDB.getNotes());
			
		
			
			//Wait care to show
			System.out.println("Press any key to continue");
			try {
				getInput();
			} catch (Exception e) {
				
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

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Care", "doControl", request);
	}

}
