package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.PaymentRepository;
import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;


/**
 * Estende AbstractService con parametri Payment e PaymentDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class PaymentService extends AbstractService<Payment,PaymentDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public PaymentDTO findById(int id) {
		return converter.toDTO(((PaymentRepository)repository).findById(id));
	}

}
