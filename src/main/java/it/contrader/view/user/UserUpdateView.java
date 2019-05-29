package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserUpdateView implements View {

	private UserController usersController;
	private Request request;

	public UserUpdateView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int userIdToUpdate;
		String username, usertype, password, name, surname, ssc;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\nUser update\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UserDTO userDTO = new UserDTO();

		System.out.println("Insert the user ID to update");
		try {
			userIdToUpdate = Integer.parseInt(getInput());
			if (userIdToUpdate != 0) {
				userDTO.setUserId(userIdToUpdate);

				System.out.println("Insert new username:");
				username = getInput();
				if (!username.equals(""))
					userDTO.setUsername(username);

				System.out.println("Insert new user type:");
				usertype = getInput();
				if (!usertype.equals(""))
					userDTO.setUsertype(usertype);

				System.out.println("Insert new password:");
				password = getInput();
				if (!password.equals(""))
					userDTO.setPassword(password);

				System.out.println("Insert new name:");
				name = getInput();
				if (!name.equals(""))
					userDTO.setName(name);

				
				System.out.println("Insert new surname:");
				surname = getInput();
				if (!surname.equals(""))
					userDTO.setSurname(surname);
				
				System.out.println("Insert new social security number:");
				ssc = getInput();
				if (!ssc.equals(""))
					userDTO.setCf(ssc);

				usersController.updateUser(userDTO);

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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
