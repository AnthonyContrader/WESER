package it.contrader.controller;

import java.util.List;

import it.contrader.dto.DeviceDocDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.DeviceDoc;
import it.contrader.service.DeviceDocService;

public class DeviceDocController implements Controller {

	private static String sub_package = "deviceDoc.";
	private DeviceDocService deviceDocsService;
	private Request request;

	public DeviceDocController() {
		this.deviceDocsService = new DeviceDocService();
	}

	public List<DeviceDoc> getAllDeviceDoc() {
		return this.deviceDocsService.getAllDeviceDoc();
	}

	public DeviceDocDTO readDeviceDoc(int deviceDocId) {
		return this.deviceDocsService.readDeviceDoc(deviceDocId);
	}


	public boolean updateDeviceDoc(DeviceDocDTO deviceDocsDTO) {
		return this.deviceDocsService.updateDeviceDoc(deviceDocsDTO);
	}


	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("DeviceDoc", null);
		} else {
			switch (choice) {
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "DeviceDocRead", null);
				break;
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "DeviceDocUpdate", null);
				break;
			case "3":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
