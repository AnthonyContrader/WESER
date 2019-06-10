package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.PaymentConverter;
import it.contrader.dao.PaymentDAO;
import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class PaymentServiceDTO {

	private final PaymentDAO paymentDAO;

	public PaymentServiceDTO() {
		this.paymentDAO = new PaymentDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<PaymentDTO> getAllPayments() {

		List<Payment> list = paymentDAO.getAllPayment();
		List<PaymentDTO> listDTO = new ArrayList<>();

		for (Payment payment : list) {
			listDTO.add(PaymentConverter.toDTO(payment));
		}

		return listDTO;
	}
	

	public PaymentDTO readPayment(PaymentDTO paymentDTO) {
		return PaymentConverter.toDTO(this.paymentDAO.readPayment(PaymentConverter.toEntity(paymentDTO)));
	}
	
	public boolean updatePayment(PaymentDTO paymentDTO) {
		return this.paymentDAO.updatePayment(PaymentConverter.toEntity(paymentDTO));
		
}
	
	public boolean deletePayments (PaymentDTO paymentDTO) {
		return this.paymentDAO.deletePayment(PaymentConverter.toEntity(paymentDTO));
		
}
	
	public boolean insertPayments (PaymentDTO paymentsDTO) {
		return this.paymentDAO.insertPayment(PaymentConverter.toEntity(paymentsDTO));
	
}
		
	
	
}
