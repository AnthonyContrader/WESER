package it.contrader.view.payment;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.PaymentController;
import it.contrader.dto.PaymentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class PaymentUpdateView implements View {

	private PaymentController paymentsController;
	private Request request;

	public PaymentUpdateView() {
		this.paymentsController = new PaymentController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int pay_idToUpdate;
		String card_type, card_number, card_owner, card_expire;
		int CVV;

		/*
		 * List<Payment> payments; Integer paymentsId; String password; payments =
		 * paymentsController.getAllPayments();
		 */
		System.out.println("\nPayment update\n");
		// System.out.println();
		// payments.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		PaymentDTO paymentDTO = new PaymentDTO();

		System.out.println("Insert the payment ID to update");
		try {
			pay_idToUpdate = Integer.parseInt(getInput());
			if (pay_idToUpdate != 0) {
				paymentDTO.setPay_id(pay_idToUpdate);

				System.out.println("Insert new payment type:");
				card_type = getInput();
				if (!card_type.equals(""))
					paymentDTO.setCard_type(card_type);

				System.out.println("Insert new card number:");
				card_number = getInput();
				if (!card_number.equals(""))
					paymentDTO.setCard_number(card_number);

				System.out.println("Insert new card owner:");
				card_owner = getInput();
				if (!card_owner.equals(""))
					paymentDTO.setCard_owner(card_owner);

				
				System.out.println("Insert new card expire:");
				card_expire = getInput();
				if (!card_expire.equals(""))
					paymentDTO.setCard_expire(card_expire);
				
				System.out.println("Insert new CVV:");
				CVV = getInt();
				if (!(CVV <0))
					paymentDTO.setCVV(CVV);

				paymentsController.updatePayment(paymentDTO);

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

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Payment", "doControl", request);
	}

}
