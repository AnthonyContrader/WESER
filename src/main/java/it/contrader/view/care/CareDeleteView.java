package it.contrader.view.care;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.CareController;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class CareDeleteView implements View {

	private CareController careController;
	private Request request;

	public CareDeleteView() {
		this.careController = new CareController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<Care> cares;
		//String caresId;

		//cares = careController.getAllCare();
		System.out.println("Select care to delete: ");
		//System.out.println();
		//care.forEach(care -> System.out.println(care));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String caresId = getInput();

		if (caresId != null && StringUtils.isStrictlyNumeric(caresId)) {
			careController.deleteCare(Integer.parseInt(caresId));
			
		} else {
			System.out.println("Incorrect entry");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Care", "doControl", request);
	}

}
