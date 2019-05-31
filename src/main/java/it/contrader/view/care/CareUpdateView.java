package it.contrader.view.care;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.CareController;
import it.contrader.dto.CareDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class CareUpdateView implements View {

	private CareController caresController;
	private Request request;

	public CareUpdateView() {
		this.caresController = new CareController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int careIdToUpdate;
		String patname, patcf, patology, carename, quantity, notes ;
		int  patage;
		
		/*
		 * List<Care> cares; Integer caresId; String password; cares =
		 * caresController.getAllCares();
		 */
		System.out.println("\nCare update\n");
		// System.out.println();
		// cares.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		CareDTO careDTO = new CareDTO();

		System.out.println("Insert the care ID to update");
		try {
			careIdToUpdate = Integer.parseInt(getInput());
			if (careIdToUpdate != 0) {
				careDTO.setCareId(careIdToUpdate);

				System.out.println("Insert new patient name:");
				patname = getInput();
				if (!patname.equals(""))
					careDTO.setPatname(patname);

				System.out.println("Insert new patient SSC:");
				patcf = getInput();
				if (!patcf.equals(""))
					careDTO.setPatcf(patcf);

				System.out.println("Insert new patient age:");
				patage = getInt();
				if (!(patage <0))
					careDTO.setPatage(patage);

				
				System.out.println("Insert new patology:");
				patology = getInput();
				if (!patology.equals(""))
					careDTO.setPatology(patology);
				
				System.out.println("Insert new care name:");
				carename = getInput();
				if (!carename.equals(""))
					careDTO.setCarename(carename);
				
				System.out.println("Insert new quantity:");
				quantity = getInput();
				if (!quantity.equals(""))
					careDTO.setQuantity(quantity);
				
				System.out.println("Insert new notes:");
				notes = getInput();
				if (!notes.equals(""))
					careDTO.setNotes(notes);

				caresController.updateCare(careDTO);

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
		MainDispatcher.getInstance().callAction("Care", "doControl", request);
	}

}
