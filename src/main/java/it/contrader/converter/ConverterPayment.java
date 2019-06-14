package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;

public class ConverterPayment {

	public static PaymentDTO toDTO(Payment payment) {
		PaymentDTO paymentDTO = null;
		if (payment != null) {
			paymentDTO = new PaymentDTO();
			paymentDTO.setIdpay(payment.getIdpay());
			paymentDTO.setCardtype(payment.getCardtype());
			paymentDTO.setCardnumb(payment.getCardnumb());
			paymentDTO.setCardown(payment.getCardown());
			paymentDTO.setCardexp(payment.getCardexp());
			paymentDTO.setCvv(payment.getCvv());
		}
		return paymentDTO;
	}

	public static Payment toEntity(PaymentDTO paymentDTO) {
		Payment payment = null;
		if (paymentDTO != null) {
			payment = new Payment();
			payment.setIdpay(paymentDTO.getIdpay());
			payment.setCardtype(paymentDTO.getCardtype());
			payment.setCardnumb(paymentDTO.getCardnumb());
			payment.setCardown(paymentDTO.getCardown());
			payment.setCardexp(paymentDTO.getCardexp());
			payment.setCvv(paymentDTO.getCvv());
		}
		return payment;
	}

	public static List<PaymentDTO> toListDTO(List<Payment> list) {
		List<PaymentDTO> listPaymentDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Payment payment : list) {
				listPaymentDTO.add(ConverterPayment.toDTO(payment));
			}
		}
		return listPaymentDTO;
	}

	public static List<Payment> toListEntity(List<PaymentDTO> listPaymentDTO) {
		List<Payment> list = new ArrayList<>();
		if (!listPaymentDTO.isEmpty()) {
			for (PaymentDTO paymentDTO : listPaymentDTO) {
				list.add(ConverterPayment.toEntity(paymentDTO));
			}
		}
		return list;
	}
}
