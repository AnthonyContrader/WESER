package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.PaymentDTO;
import it.contrader.service.PaymentService;
import java.util.ArrayList;




public class PaymentServlet extends HttpServlet {

	private final PaymentService paymentsService = new PaymentService();
	private List<PaymentDTO> allPayments= new ArrayList<>();
	private int idpay;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String choice = request.getParameter("action");
		final HttpSession session = request.getSession(true); //sto impostando una serie di pulsanti

		switch (choice) {

		case "allPayments":
			showAllPayments(request,response);
			break;		

		case "insert":
			final String cardtype = request.getParameter("cardname");
			final String cardnum = request.getParameter("cardnum");
			final String cardown = request.getParameter("cardown");
			final String cardexp = request.getParameter("cardexp");
			final Integer ccv = Integer.parseInt(request.getParameter("ccv"));
			final PaymentDTO payments = new PaymentDTO();
			paymentsService.insertPayment(payments);
			showAllPayment(request, response);
			break;
					
		final String cardtype = request.getParameter("cardname");
		final String cardnum = request.getParameter("cardnum");
		final String cardown = request.getParameter("cardown");
		final String cardexp = request.getParameter("cardexp");
		final Integer ccv = Integer.parseInt(request.getParameter("ccv"));
			final PaymentDTO payment = new PaymentDTO(cardtype,cardnum, cardown,cardexp,cvv);
			System.out.println(payment);
			payment.updatePayment(payment);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer idpaydel = Integer.parseInt(request.getParameter("pay_id"));
			final PaymentDTO pay = new PaymentDTO();
			pay;
			showAllUsers(request, response);
			break;
			
		case "update2":
			final Integer idUpdate2 = Integer.parseInt(request.getParameter("id"));			
			final UsersDTO userUpdate2 = new UsersDTO(idUpdate2,"" ,"", 1);
			usersServiceDTO.updateUsers(userUpdate2);
			showAllUsers(request, response);
			break;
			
		case "Indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("index.jsp");
			break;

		}
	}
	
private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		allUsers = this.usersServiceDTO.getAllUsers();
		request.getSession().setAttribute("users_list", allUsers);
		getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
	}
}