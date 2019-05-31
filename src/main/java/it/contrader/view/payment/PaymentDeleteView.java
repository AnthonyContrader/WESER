package it.contrader.view.payment;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.PaymentController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Payment;
import it.contrader.view.View;

public class PaymentDeleteView implements View {

	private PaymentController paymentController;
	private Request request;

	public PaymentDeleteView() {
		this.paymentController = new PaymentController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<Payment> payments;
		//String paymentsId;

		//payments = paymentController.getAllPayment();
		System.out.println("Select payment to delete: ");
		//System.out.println();
		//payment.forEach(payment -> System.out.println(payment));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String paymentsId = getInput();

		if (paymentsId != null && StringUtils.isStrictlyNumeric(paymentsId)) {
			paymentController.deletePayment(Integer.parseInt(paymentsId));
			
		} else {
			System.out.println("Incorrect entry");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Payment", "doControl", request);
	}

}
