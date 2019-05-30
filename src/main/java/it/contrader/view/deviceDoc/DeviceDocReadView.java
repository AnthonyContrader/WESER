package it.contrader.view.deviceDoc;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceDocController;
import it.contrader.dto.DeviceDocDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DeviceDocReadView implements View {

	private DeviceDocController devicesDocController;
	private Request request;

	public DeviceDocReadView() {
		this.devicesDocController = new DeviceDocController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int deviceDocIdToRead;

		System.out.println("Insert device ID");

		try {
			deviceDocIdToRead = Integer.parseInt(getInput());
			DeviceDocDTO deviceDocDB = devicesDocController.readDeviceDoc(deviceDocIdToRead);

			System.out.println("Id " + deviceDocDB.getDevId());
			System.out.println("Registration number " + deviceDocDB.getRegnumber());
			System.out.println("Device type " + deviceDocDB.getDevtype());
			System.out.println("Description " + deviceDocDB.getDescription());
			System.out.println("Min pressure " + deviceDocDB.getMinpress());
			System.out.println("Max pressure " + deviceDocDB.getMaxpress());
			System.out.println("Min heartbeats " + deviceDocDB.getMincir());
			System.out.println("Max heartbeats " + deviceDocDB.getMaxcir());
			System.out.println("Min breaths " + deviceDocDB.getMinbreath());
			System.out.println("Max breaths " + deviceDocDB.getMaxbreath());
			System.out.println("Min temperature " + deviceDocDB.getMintemp());
			System.out.println("Max temperature " + deviceDocDB.getMaxtemp());

			//Wait device to show
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
		MainDispatcher.getInstance().callAction("DeviceDoc", "doControl", request);
	}

}
