package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterPayment;
import it.contrader.dao.PaymentDAO;
import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;


public class PaymentService {

	private final PaymentDAO paymentsDAO;

	public PaymentService() {
		this.paymentsDAO = new PaymentDAO();
	}

	
	public List<PaymentDTO> getAllPayment() {

		List<Payment> list = paymentsDAO.getAllPayment();
		List<PaymentDTO> listDTO = new ArrayList<>();

		for (Payment payments: list) {
			listDTO.add(ConverterPayment.toDTO(payments));
		}

		return listDTO;
	}

	public String register (String cardtype,String cardname, String cardown, String cardexp,int cvv) {
		return this.paymentsDAO.register(cardtype, cardname, cardown, cardexp, cvv);
	}
	public  boolean insertPayment(PaymentDTO paymentDTO) {
		return this.paymentsDAO.insertPayment((ConverterPayment.toEntity(paymentDTO)));
	}
	
	public PaymentDTO readPayment(int paymentId) {
		return ConverterPayment.toDTO(this.paymentsDAO.readPayment(paymentId));
	}
	
	public boolean updatePayment(PaymentDTO paymentDTO) {
		return this.paymentsDAO.updatePayment(ConverterPayment.toEntity(paymentDTO));
	}
	
	public boolean deletePayment(int paymentId) {
		return this.paymentsDAO.deletePayment(paymentId);
	}
	
	
}
