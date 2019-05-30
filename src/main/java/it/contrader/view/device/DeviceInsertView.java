package it.contrader.view.device;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.DeviceController;
import it.contrader.dto.DeviceDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class DeviceInsertView implements View {

	private DeviceController devicesController;
	private Request request;

	public DeviceInsertView() {
		this.devicesController = new DeviceController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String regnumber, devtype, description;
		int  minpress, maxpress, mincir, maxcir, minbreath, maxbreath;
		float mintemp, maxtemp;

		System.out.println("Insert registration number");
		regnumber = getInput();
		System.out.println("Insert device type");
		devtype=getInput();
		System.out.println("Insert description");
		description=getInput();
		System.out.println("Insert min pressure");
		minpress=getInt();
		System.out.println("Insert max pressure");
		maxpress=getInt();
		System.out.println("Insert min heartbeats");
		mincir=getInt();
		System.out.println("Insert max heartbeats");
		maxcir=getInt();
		System.out.println("Insert min breaths");
		minbreath=getInt();
		System.out.println("Insert max breaths");
		maxbreath=getInt();
		System.out.println("Insert min temperature");
		mintemp=getFloat();
		System.out.println("Insert max temperature");
		maxtemp=getFloat();
		
		
		if (!regnumber.equals("") && !devtype.equals("") && !description.equals("") && !(minpress <0) && !(maxpress <0) && !(mincir <0) && !(maxcir <0) && !(minbreath <0)&& !(maxbreath <0)&& !(mintemp <0)&& !(maxtemp <0)) {
			devicesController.insertDevice(new DeviceDTO(regnumber, devtype, description,minpress, maxpress, mincir, maxcir, minbreath, maxbreath, mintemp, maxtemp));
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
		MainDispatcher.getInstance().callAction("Device", "doControl", request);
	}

}
