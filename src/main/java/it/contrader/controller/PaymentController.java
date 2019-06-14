package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PaymentDTO;
import it.contrader.services.PaymentService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Payment")
public class PaymentController {

	private final PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping(value = "/paymentManagement", method = RequestMethod.GET)
	public List<PaymentDTO> paymentManagement() {
		// PaymentDTO paymentDTOPaymentList = new PaymentDTO();
		// paymentDTOPaymentList.setPaymentId(paymentId);
		return this.paymentService.findAllPaymentDTO();
	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public PaymentDTO read(@RequestParam(value = "paymentId") int id) {
			PaymentDTO readPayment = new PaymentDTO();
			readPayment = this.paymentService.getPaymentDTOById(id);
			return readPayment;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "paymentId") int id) {
			this.paymentService.deletePaymentById(id);
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody PaymentDTO payment) {
			paymentService.updatePayment(payment);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody PaymentDTO payment) {
			paymentService.insertPayment(payment);
		}

}