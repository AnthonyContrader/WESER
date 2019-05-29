package it.contrader.view.user;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserInsertView implements View {

	private UserController usersController;
	private Request request;

	public UserInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String username, usertype, password, name, surname, ssc;

		System.out.println("Insert username");
		username = getInput();
		System.out.println("Insert user type");
		usertype=getInput();
		System.out.println("Insert password");
		password=getInput();
		System.out.println("Insert name");
		name=getInput();
		System.out.println("Insert surname");
		surname=getInput();
		System.out.println("Insert social security number");
		ssc=getInput();
		
		if (!username.equals("") && !usertype.equals("") && !password.equals("") && !name.equals("") && !surname.equals("") && !ssc.equals("")) {
			usersController.insertUser(new UserDTO(username, usertype, password, name, surname, ssc));
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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
