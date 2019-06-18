package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PaymentDTO;
import it.contrader.model.Payment;


/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class PaymentConverter extends AbstractConverter<Payment,PaymentDTO> {

	@Override
	public Payment toEntity(PaymentDTO paymentDTO) {
		Payment payment= null;
		if (paymentDTO != null) {
			payment= new Payment(paymentDTO.getId(),paymentDTO.getCt(),paymentDTO.getCn(),paymentDTO.getCo(),paymentDTO.getCe(),paymentDTO.getCvv());			
		}
		return payment;
	}

	@Override
	public PaymentDTO toDTO(Payment payment) {
		PaymentDTO paymentDTO = null;
		if (payment!= null) {
			paymentDTO = new PaymentDTO(payment.getId(),payment.getCt(),payment.getCn(),payment.getCo(),payment.getCe(),payment.getCvv());
			
		}
		return paymentDTO;
	}
}