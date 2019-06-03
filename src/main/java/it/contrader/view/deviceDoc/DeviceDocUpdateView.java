package it.contrader.view.deviceDoc;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceDocController;
import it.contrader.dto.DeviceDocDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DeviceDocUpdateView implements View {

	private DeviceDocController devicesDocController;
	private Request request;

	public DeviceDocUpdateView() {
		this.devicesDocController = new DeviceDocController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int deviceDocIdToUpdate;
		//String regnumber, devtype, description;
		int minpress, maxpress, mincir, maxcir, minbreath, maxbreath;
		float mintemp, maxtemp;

		/*
		 * List<Device> devices; Integer devicesId; String password; devices =
		 * devicesController.getAllDevices();
		 */
		System.out.println("\nDevices update \n");
		System.out.println("\nThe parameters signed by * are required \n");
		// System.out.println();
		// devices.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		DeviceDocDTO deviceDocDTO = new DeviceDocDTO();

		System.out.println("Insert the device ID to update");
		try {
			deviceDocIdToUpdate = Integer.parseInt(getInput());
			if (deviceDocIdToUpdate != 0) {
				deviceDocDTO.setDevId(deviceDocIdToUpdate);

				System.out.println("Insert new min pressure(*) ");
				minpress = getInt();
				if (!(minpress < 0))
					deviceDocDTO.setMinpress(minpress);

				System.out.println("Insert new max pressure(*) ");
				maxpress = getInt();
				if (!(maxpress < 0))
					deviceDocDTO.setMaxpress(maxpress);
				
				System.out.println("Insert new min heartbeats(*) ");
				mincir = getInt();
				if (!(mincir < 0))
					deviceDocDTO.setMincir(mincir);

				System.out.println("Insert new max heartbeats(*) ");
				maxcir = getInt();
				if (!(maxcir < 0))
					deviceDocDTO.setMaxcir(maxcir);
				
				System.out.println("Insert new min breaths(*) ");
				minbreath = getInt();
				if (!(minbreath < 0))
					deviceDocDTO.setMinbreath(minbreath);

				System.out.println("Insert new max breaths(*) ");
				maxbreath = getInt();
				if (!(maxbreath < 0))
					deviceDocDTO.setMaxbreath(maxbreath);
			
				System.out.println("Insert new min temperature(*) ");
				mintemp = getFloat();
				if (!(mintemp < 0))
					deviceDocDTO.setMintemp(mintemp);

				System.out.println("Insert new max temperature(*) ");
				maxtemp = getFloat();
				if (!(maxtemp < 0))
					deviceDocDTO.setMaxtemp(maxtemp);
				
				devicesDocController.updateDeviceDoc(deviceDocDTO);

			}
		} catch (Exception e) {
			System.out.println("Incorrect entry or required parameters not included");
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

	public float getFloat() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextFloat();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("DeviceDoc", "doControl", request);
	}

}
