package it.contrader.view.emergency;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.EmergencyController;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class EmergencyDeleteView implements View {

	private EmergencyController emergencyController;
	private Request request;

	public EmergencyDeleteView() {
		this.emergencyController = new EmergencyController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<Emergency> emergencys;
		//String emergencysId;

		//emergencys = emergencyController.getAllEmergency();
		System.out.println("Select emergency to delete: ");
		//System.out.println();
		//emergency.forEach(emergency -> System.out.println(emergency));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String emergencysId = getInput();

		if (emergencysId != null && StringUtils.isStrictlyNumeric(emergencysId)) {
			emergencyController.deleteEmergency(Integer.parseInt(emergencysId));
			
		} else {
			System.out.println("Incorect entry");
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
		MainDispatcher.getInstance().callAction("Emergency", "doControl", request);
	}

}
