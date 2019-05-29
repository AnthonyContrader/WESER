package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;
import it.contrader.service.DeviceService;

public class DeviceController implements Controller {

	private static String sub_package = "device.";
	private DeviceService devicesService;
	private Request request;

	public DeviceController() {
		this.devicesService = new DeviceService();
	}

	public List<Device> getAllDevice() {
		return this.devicesService.getAllDevice();
	}

	public DeviceDTO readDevice(int devId) {
		return this.devicesService.readDevice(devId);
	}

	public boolean insertDevice(DeviceDTO devicesDTO) {
		return this.devicesService.insertDevice(devicesDTO);
	}

	public boolean updateDevice(DeviceDTO devicesDTO) {
		return this.devicesService.updateDevice(devicesDTO);
	}

	public boolean deleteDevice(Integer devicesId) {
		return this.devicesService.deleteDevice(devicesId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Device", null);
		} else {
			switch (choice) {
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "DeviceRead", null);
				break;
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "DeviceInsert", null);
				break;
			case "3":
				MainDispatcher.getInstance().callView(sub_package + "DeviceUpdate", null);
				break;
			case "4":
				MainDispatcher.getInstance().callView(sub_package + "DeviceDelete", null);
				break;
			case "5":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
