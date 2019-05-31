package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;

public class ConverterPayment {

	public static PaymentDTO toDTO(Payment payment) {
		PaymentDTO paymentDTO = null;
		if (payment != null) {
			paymentDTO.setPay_id(payment.getPay_id());
			paymentDTO.setCard_type(payment.getCard_type());
			paymentDTO.setCard_number(payment.getCard_number());
			paymentDTO.setCard_owner(payment.getCard_owner());
			paymentDTO.setCard_expire(payment.getCard_expire());
			paymentDTO.setCVV(payment.getCVV());
		}
		return paymentDTO;
	}

	public static Payment toEntity(PaymentDTO paymentDTO) {
		Payment payment = null;
		if (paymentDTO != null) {
			payment = new Payment();
			payment.setPay_id(payment.getPay_id());
			payment.setCard_type(payment.getCard_type());
			payment.setCard_number(payment.getCard_number());
			payment.setCard_owner(payment.getCard_owner());
			payment.setCard_expire(payment.getCard_expire());
			payment.setCVV(payment.getCVV());
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
