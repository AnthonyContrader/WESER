package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.service.PaymentService;
import it.contrader.service.UserService;
import it.contrader.utils.Request;



public class RegisterServlet extends HttpServlet {

	private final PaymentService paymentsService = new UserService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("nomeUtente", null);

		if (request != null) {
			final String cardtype = request.getParameter("cardtype");
			final String cardnum = request.getParameter("cardnum");
			final String cardown = request.getParameter("cardown");
			final String cardexp = request.getParameter("cardexp");
			final int cvv = Integer.parseInt(request.getParameter("cvv"));
			// recuperiamo l'utente
			paymentsService.register(cardtype, cardnum, cardown, cardexp, cvv);

			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		}
	}

}
