package it.contrader.view.care;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.CareController;
import it.contrader.dto.CareDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class CareInsertView implements View {

	private CareController caresController;
	private Request request;

	public CareInsertView() {
		this.caresController = new CareController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String patname, patcf, patology, carename, quantity, notes;
		int  patage;
		
		
		System.out.println("Insert patient name");
		patname = getInput();
		System.out.println("Insert Social Security Number");
		patcf=getInput();
		System.out.println("Insert patient age");
		patage=getInt();
		System.out.println("Insert patology");
		patology=getInput();
		System.out.println("Insert care name");
		carename=getInput();
		System.out.println("Insert quantity");
		quantity=getInput();
		System.out.println("Insert notes");
		notes=getInput();
		
		
		if (!patname.equals("") && !patcf.equals("") && !(patage <0) && !patology.equals("") && !carename.equals("") && !quantity.equals("") && !notes.equals("")) {
			caresController.insertCare(new CareDTO(patname, patcf, patage, patology, carename, quantity, notes));
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
	
	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Care", "doControl", request);
	}

}
