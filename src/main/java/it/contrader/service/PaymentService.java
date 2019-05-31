package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterPayment;
import it.contrader.dao.PaymentDAO;
import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;

public class PaymentService {

	private PaymentDAO paymentDAO;

	public PaymentService() {
		this.paymentDAO = new PaymentDAO();
	}

	public List<Payment> getAllPayment() {
		return this.paymentDAO.getAllPayment();
	}

	public boolean insertPayment(PaymentDTO paymentDTO) {
		return this.paymentDAO.insertPayment(ConverterPayment.toEntity(paymentDTO));
	}
	
	public PaymentDTO readPayment(int paymentId) {
		return ConverterPayment.toDTO(this.paymentDAO.readPayment(paymentId));
	}
	
	public boolean updatePayment(PaymentDTO paymentDTO) {
		return this.paymentDAO.updatePayment(ConverterPayment.toEntity(paymentDTO));
	}
	
	public boolean deletePayment(int paymentId) {
		return this.paymentDAO.deletePayment(paymentId);
	}
	
	
}
