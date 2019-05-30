package it.contrader.view.device;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceController;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DeviceDeleteView implements View {

	private DeviceController deviceController;
	private Request request;

	public DeviceDeleteView() {
		this.deviceController = new DeviceController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<Device> devices;
		//String devicesId;

		//devices = deviceController.getAllDevice();
		System.out.println("Select device to delete: ");
		//System.out.println();
		//device.forEach(device -> System.out.println(device));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String devicesId = getInput();

		if (devicesId != null && StringUtils.isStrictlyNumeric(devicesId)) {
			deviceController.deleteDevice(Integer.parseInt(devicesId));
			
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
		MainDispatcher.getInstance().callAction("Device", "doControl", request);
	}

}
