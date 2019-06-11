package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.PaymentDTO;
import it.contrader.services.PaymentService;

import java.util.List;


@Controller
@RequestMapping("/Payment")
public class PaymentController {

	private final PaymentService paymentService;
	private HttpSession session;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	private void visualPayment(HttpServletRequest request){
		List<PaymentDTO> allPayment = this.paymentService.getListaPaymentDTO();
		request.setAttribute("allPaymentDTO", allPayment);
	}
	
	@RequestMapping(value = "/paymentManagement", method = RequestMethod.GET)
	public String paymentManagement(HttpServletRequest request) {
		visualPayment(request);
		return "homeTutor";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.paymentService.deletePaymentById(id);
		visualPayment(request);
		return "homeTutor";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualPayment(request);
		request.setAttribute("option", "insert");
		return "insertPayment";
		
	}
	
	@RequestMapping(value = "/searchPayment", method = RequestMethod.GET)
	public String cercaPayment(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<PaymentDTO> allPayment = this.paymentService.findPaymentDTOById(content);
		request.setAttribute("allPaymentDTO", allPayment);

		return "homeTutor";

	}
	
	@RequestMapping(value = "/insertPayment", method = RequestMethod.POST)
	public String insertPayment(HttpServletRequest request) {
		String cardtype = request.getParameter("cardtype").toString();
		String cardnumb = request.getParameter("cardown").toString();
		String cardexp = request.getParameter("cardexp").toString();
		int cvv = Integer.parseInt(request.getParameter("cvv"));

		PaymentDTO paymentObj = new PaymentDTO();
		
		paymentService.insertPayment(paymentObj);

		visualPayment(request);
		return "homePayment";
	}
	
}
