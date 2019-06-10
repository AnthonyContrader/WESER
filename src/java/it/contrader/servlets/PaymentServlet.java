package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.PaymentDTO;
import it.contrader.service.PaymentServiceDTO;


@SuppressWarnings("serial")
public class PaymentServlet extends HttpServlet {

	private final PaymentServiceDTO paymentServiceDTO = new PaymentServiceDTO();
	private List<PaymentDTO> allPayments = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "PaymentManager":
			allPayments = this.paymentServiceDTO.getAllPayments();
			request.setAttribute("allPayment", allPayments);
			getServletContext().getRequestDispatcher("/payment/managePayment.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/payment/insertPayment.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("payment_id"));
			final String cardtype = request.getParameter("cardtype");
			final String cardnum = request.getParameter("cardnum");
			final String cardown = request.getParameter("cardown");
			final String cardexp = request.getParameter("cardexp");
			final int cvv = Integer.parseInt(request.getParameter("cvv"));
			final PaymentDTO payments = new PaymentDTO(cardtype,cardnum,cardown,cardexp,cvv);
			paymentServiceDTO.insertPayments(payments);
			showAllPayments(request, response);
			break;

		case "updateRedirect":
			int payId = Integer.parseInt(request.getParameter("payId"));
			PaymentDTO paymentUpdate = new PaymentDTO("","","","",0);
			paymentUpdate.setPayId(payId);

			paymentUpdate = this.paymentServiceDTO.readPayment(paymentUpdate);
			request.setAttribute("paymentUpdate", paymentUpdate);
			getServletContext().getRequestDispatcher("/payment/updatePayment.jsp").forward(request, response);

			break;

		case "update":
		
			final int payIdUpdate = Integer.parseInt(request.getParameter("pay_id"));
			final String cardtypeUpdate= request.getParameter("cardtype");
			final String cardnumUpdate = request.getParameter("cardnum");
			final String cardownUpdate = request.getParameter("cardown");
			final String cardexpUpdate = request.getParameter("cardexp");
			final int cvvUpdate = Integer.parseInt(request.getParameter("cvv"));
			final PaymentDTO payment = new PaymentDTO(cardtypeUpdate,cardnumUpdate,cardownUpdate,cardexpUpdate,cvvUpdate);
			payment.setPayId(payIdUpdate);

			paymentServiceDTO.updatePayment(payment);
			showAllPayments(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("payId"));

			final PaymentDTO paymentdelete = new PaymentDTO("", "", "","",0);
			paymentdelete.setPayId(deleteId);
			paymentServiceDTO.deletePayments(paymentdelete);
			showAllPayments(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeTutor.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;


		}

	}

	private void showAllPayments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allPayments = this.paymentServiceDTO.getAllPayments();
		request.setAttribute("allPayment", allPayments);
		getServletContext().getRequestDispatcher("/payment/managePayment.jsp").forward(request, response);
	}
}