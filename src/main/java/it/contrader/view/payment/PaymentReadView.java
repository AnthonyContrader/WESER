package it.contrader.view.payment;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.PaymentController;
import it.contrader.dto.PaymentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Payment;
import it.contrader.view.View;

public class PaymentReadView implements View {

	private PaymentController paymentsController;
	private Request request;

	public PaymentReadView() {
		this.paymentsController = new PaymentController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int paymentIdToRead;

		System.out.println("Insert payment ID ");

		try {
			paymentIdToRead = Integer.parseInt(getInput());
			PaymentDTO paymentDB = paymentsController.readPayment(paymentIdToRead);

			System.out.println("Id: " + paymentDB.getPay_id());
			System.out.println("Card type: " + paymentDB.getCard_type());
			System.out.println("Card number: " + paymentDB.getCard_number());
			System.out.println("Card owner: " + paymentDB.getCard_owner());
			System.out.println("Card expire: " + paymentDB.getCard_expire());
			System.out.println("CVV: " + paymentDB.getCVV());
			
			//Wait payment to show
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
		MainDispatcher.getInstance().callAction("Payment", "doControl", request);
	}

}
