package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PaymentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Payment;
import it.contrader.service.PaymentService;

public class PaymentController implements Controller {

	private static String sub_package = "payment.";
	private PaymentService paymentsService;
	private Request request;

	public PaymentController() {
		this.paymentsService = new PaymentService();
	}

	public List<Payment> getAllPayment() {
		return this.paymentsService.getAllPayment();
	}

	public PaymentDTO readPayment(int pay_id) {
		return this.paymentsService.readPayment(pay_id);
	}

	public boolean insertPayment(PaymentDTO paymentsDTO) {
		return this.paymentsService.insertPayment(paymentsDTO);
	}

	public boolean updatePayment(PaymentDTO paymentsDTO) {
		return this.paymentsService.updatePayment(paymentsDTO);
	}

	public boolean deletePayment(Integer paymentsId) {
		return this.paymentsService.deletePayment(paymentsId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Payment", null);
		} else {
			switch (choice) {
			case "1":
				MainDispatcher.getInstance().callView(sub_package + "PaymentRead", null);
				break;
			case "2":
				MainDispatcher.getInstance().callView(sub_package + "PaymentInsert", null);
				break;
			case "3":
				MainDispatcher.getInstance().callView(sub_package + "PaymentUpdate", null);
				break;
			case "4":
				MainDispatcher.getInstance().callView(sub_package + "PaymentDelete", null);
				break;
			case "5":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
