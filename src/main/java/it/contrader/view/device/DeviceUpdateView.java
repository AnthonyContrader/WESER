package it.contrader.view.device;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceController;
import it.contrader.dto.DeviceDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DeviceUpdateView implements View {

	private DeviceController devicesController;
	private Request request;

	public DeviceUpdateView() {
		this.devicesController = new DeviceController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int deviceIdToUpdate;
		String regnumber, devtype, description;
		int  minpress, maxpress, mincir, maxcir, minbreath, maxbreath;
		float mintemp, maxtemp;
		
		/*
		 * List<Device> devices; Integer devicesId; String password; devices =
		 * devicesController.getAllDevices();
		 */
		System.out.println("\nDevice update\n");
		// System.out.println();
		// devices.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		DeviceDTO deviceDTO = new DeviceDTO();

		System.out.println("Insert the device ID to update");
		try {
			deviceIdToUpdate = Integer.parseInt(getInput());
			if (deviceIdToUpdate != 0) {
				deviceDTO.setDevId(deviceIdToUpdate);

				System.out.println("Insert new registration number:");
				regnumber = getInput();
				if (!regnumber.equals(""))
					deviceDTO.setRegnumber(regnumber);

				System.out.println("Insert new device type:");
				devtype = getInput();
				if (!devtype.equals(""))
					deviceDTO.setDevtype(devtype);

				System.out.println("Insert new description:");
				description = getInput();
				if (!description.equals(""))
					deviceDTO.setDescription(description);

				System.out.println("Insert new min pressure:");
				minpress = getInt();
				if (!(minpress <0))
					deviceDTO.setMinpress(minpress);

				
				System.out.println("Insert new max pressure:");
				maxpress = getInt();
				if (!(maxpress <0))
					deviceDTO.setMaxpress(maxpress);
				
				System.out.println("Insert new min heartbeats:");
				mincir = getInt();
				if (!(mincir <0))
					deviceDTO.setMincir(mincir);
					
				
				System.out.println("Insert new max heartbeats:");
				maxcir = getInt();
				if (!(maxcir <0))
					deviceDTO.setMaxcir(maxcir);
				
				System.out.println("Insert new min breath:");
				minbreath = getInt();
				if (!(minbreath <0))
					deviceDTO.setMinbreath(minbreath);

				
				System.out.println("Insert new max breath:");
				maxbreath = getInt();
				if (!(maxbreath <0))
					deviceDTO.setMaxbreath(maxbreath);
				
				System.out.println("Insert new min temperature:");
				mintemp = getFloat();
				if (!(mintemp<0))
					deviceDTO.setMintemp(mintemp);

				
				System.out.println("Insert new max temperature:");
				maxtemp = getFloat();
				if (!(maxtemp <0))
					deviceDTO.setMaxtemp(maxtemp);

				devicesController.updateDevice(deviceDTO);

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
	
	public int getInt() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public Float getFloat() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextFloat();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Device", "doControl", request);
	}

}
