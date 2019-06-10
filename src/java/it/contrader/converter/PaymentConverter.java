package it.contrader.converter;

import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;

public class PaymentConverter {

public static Payment toEntity(PaymentDTO paymentDTO) {

		Payment payment = null;
		if (paymentDTO != null) {
			payment = new Payment(paymentDTO.getCardtype(),  paymentDTO.getCardnum(),paymentDTO.getCardown(),paymentDTO.getCardexp(),paymentDTO.getCvv());

			if (paymentDTO.getPayId() != null)
				payment.setPayId(paymentDTO.getPayId());
		}
		

		return payment;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static PaymentDTO toDTO(Payment payment) {

		PaymentDTO paymentDTO = null;
		if (payment != null) {
			paymentDTO = new PaymentDTO(payment.getCardtype(),payment.getCardnum(),payment.getCardown(),payment.getCardexp(),payment.getCvv());
			paymentDTO.setPayId(payment.getPayId());
			// paymentDTO.setId(payment.getPaymentId());
		}

		return paymentDTO;
	}

}