package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.service.UserService;
import it.contrader.utils.Request;



public class RegisterServlet extends HttpServlet {

	private final UserService usersService = new UserService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("nomeUtente", null);

		if (request != null) {
			final String nomeUtente = request.getParameter("username");
			final String usertype = request.getParameter("usertype");
			final String password = request.getParameter("password");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String ssc = request.getParameter("cf");
			// recuperiamo l'utente
			usersService.register(nomeUtente, usertype, password, name, surname, ssc);

			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		}
	}

}












