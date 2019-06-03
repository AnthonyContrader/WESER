package it.contrader.view.payment;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.PaymentController;
import it.contrader.dto.PaymentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class PaymentInsertView implements View {

	private PaymentController paymentsController;
	private Request request;

	public PaymentInsertView() {
		this.paymentsController = new PaymentController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String card_type, card_number, card_owner, card_expire;
		int CVV;
		System.out.println("Insert card type");
		card_type=getInput();
		System.out.println("Insert card number");
		card_number=getInput();
		System.out.println("Insert card owner");
		card_owner=getInput();
		System.out.println("Insert card expire");
		card_expire=getInput();
		System.out.println("Insert CVV");
		CVV=getInt();
		
		if (!card_type.equals("") && !card_number.equals("") && !card_owner.equals("") && !card_expire.equals("") && !(CVV < 0)) {
			paymentsController.insertPayment(new PaymentDTO(card_type, card_number, card_owner, card_expire, CVV));
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

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Payment", "doControl", request);
	}

}
