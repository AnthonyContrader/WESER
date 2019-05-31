package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Device;

public class DeviceView implements View {

	private DeviceController devicesController;
	private Request request;
	private String choice;
	
	public DeviceView() {
		this.devicesController = new DeviceController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n DEVICES ADMINISTRATION \n");
		System.out.println("ID\t Registration number\t Device type\t Description\t Min pressure\t Max pressure\t Min circulation\t Max circulation\t Min #breath\t Max #breath\t Min temperature\t Max temperature");
		System.out.print("------------------------------------------------------");
		List<Device> devices = devicesController.getAllDevice();
		System.out.println();
		devices.forEach(device -> System.out.println(device.toString()));
		System.out.println();
		
		System.out.println("Choose operation");
		System.out.println("[1] Device view");
		System.out.println("[2] Insert new device");
		System.out.println("[3] Update existing device");
		System.out.println("[4] Delete existing device");
		System.out.println("[5] Return to login");
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
		    MainDispatcher.getInstance().callAction("Device", "doControl", this.request);
	}

}
