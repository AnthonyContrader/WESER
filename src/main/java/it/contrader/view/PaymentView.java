package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.PaymentController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Payment;

public class PaymentView implements View {

	private PaymentController paymentsController;
	private Request request;
	private String choice;
	
	public PaymentView() {
		this.paymentsController = new PaymentController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n PAYMENT MENU \n");
		System.out.println("ID\t Card type\t Card number\t Card owner\t Card expire\t CVV");
		System.out.print("------------------------------------------------------");
		List<Payment> payments = paymentsController.getAllPayment();
		System.out.println();
		payments.forEach(payment -> System.out.println(payment.toString()));
		System.out.println();
		
		System.out.println("Choose operation");
		System.out.println("[1] Card view");
		System.out.println("[2] Insert new card");
		System.out.println("[3] Update existing card");
		System.out.println("[4] Delete existing card");
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
		    MainDispatcher.getInstance().callAction("Payment", "doControl", this.request);
	}

}
