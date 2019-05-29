package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView implements View {

	private String username;
	private String password;

	public void showResults(Request request) {
		
	}

	public void showOptions() {
		System.out.println("USER LOGIN");
		System.out.println("Insert username:");
		username = getInput();
		System.out.println("Insert password:");
		password = getInput();
	}

	public void submit() {
		Request request = new Request();
		request.put("nomeUtente", username);
		request.put("password", password);
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
