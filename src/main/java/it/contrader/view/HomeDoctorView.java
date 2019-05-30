/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeDoctorView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Wellcome in Weser "+request.get("nomeUtente").toString());
    }


    public void showOptions() {
        System.out.println("\n DOCTOR MENU \n");
        System.out.println("Choose operation");
        System.out.println("[1]  Patients menu");
        System.out.println("[2]  Devices menu");
        System.out.println("[3]  Return to login");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("1")) {
        	MainDispatcher.getInstance().callView("Care", null);
        }
        if (choice.equalsIgnoreCase("2")) {
        	MainDispatcher.getInstance().callView("DeviceDoc", null);
        }
        
        if (choice.equalsIgnoreCase("3"))
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
