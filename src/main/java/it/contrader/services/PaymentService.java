package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterPayment;
import it.contrader.dao.PaymentRepository;
import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;

	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public List<PaymentDTO> getListaPaymentDTO() {
		return ConverterPayment.toListDTO((List<Payment>) paymentRepository.findAll());
	}

	public PaymentDTO getPaymentDTOById(Integer id) {
		return ConverterPayment.toDTO(paymentRepository.findById(id).get());
	}


	public boolean insertPayment(PaymentDTO paymentDTO) {
		return paymentRepository.save(ConverterPayment.toEntity(paymentDTO)) != null;
	}

	public boolean updatePayment(PaymentDTO paymentDTO) {
		return paymentRepository.save(ConverterPayment.toEntity(paymentDTO)) != null;
	}
	
	public void deletePaymentById(Integer id) {
		paymentRepository.deleteById(id);
	}
	
	public List<PaymentDTO> findPaymentDTOByPaymentname(String paymentname) {
		
		final List<Payment> list = paymentRepository.findAllById();
		final List<PaymentDTO> paymentDTOs = new ArrayList<>();
		list.forEach(i -> paymentDTOs.add(ConverterPayment.toDTO(i)));
		return paymentDTOs;
		
	
	}

	public List<PaymentDTO> findPaymentDTOById(String content) {
		// TODO Auto-generated method stub
		return null;
	}
}
