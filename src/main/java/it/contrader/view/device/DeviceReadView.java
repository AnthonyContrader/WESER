package it.contrader.view.device;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceController;
import it.contrader.dto.DeviceDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Device;
import it.contrader.view.View;

public class DeviceReadView implements View {

	private DeviceController devicesController;
	private Request request;

	public DeviceReadView() {
		this.devicesController = new DeviceController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int deviceIdToRead;

		System.out.println("Insert device ID ");

		try {
			deviceIdToRead = Integer.parseInt(getInput());
			DeviceDTO deviceDB = devicesController.readDevice(deviceIdToRead);

			System.out.println("Id: " + deviceDB.getDevId());
			System.out.println("Registration number: " + deviceDB.getRegnumber());
			System.out.println("Device type: " + deviceDB.getDevtype());
			System.out.println("Description: " + deviceDB.getDescription());
			System.out.println("Min pressure: " + deviceDB.getMinpress());
			System.out.println("Max pressure: " + deviceDB.getMaxpress());
			System.out.println("Min heartbeats: " + deviceDB.getMincir());
			System.out.println("Max heartbeats: " + deviceDB.getMaxcir());
			System.out.println("Min breath: " + deviceDB.getMinbreath());
			System.out.println("Max breath: " + deviceDB.getMaxbreath());
			System.out.println("Min temperature: " + deviceDB.getMintemp());
			System.out.println("Max temperature: " + deviceDB.getMaxtemp());
		
			
			//Wait device to show
			System.out.println("Press any key to continue");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Incorect entry");
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
		MainDispatcher.getInstance().callAction("Device", "doControl", request);
	}

}
