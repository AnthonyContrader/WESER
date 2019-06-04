package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.service.UserService;
import it.contrader.utils.Request;

public class LoginServlet extends HttpServlet {

	private final UserService usersService = new UserService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			try {
			final String nomeUtente = request.getParameter("username").toString().trim();
			final String password = request.getParameter("password").toString().trim();
			// recuperiamo l'utente
			final Request  login = usersService.login(nomeUtente, password);

			if (login != null)
				session.setAttribute("utente", login);
			

			try {
			switch (login.get("user_type").toString()) {

			case "admin":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;

			case "tutor":
				getServletContext().getRequestDispatcher("/homeTutor.jsp").forward(request, response);
				break;
			case "doctor":
				getServletContext().getRequestDispatcher("/homeDoctor.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			} catch (Exception e) {
				
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			}catch (Exception e) {
				
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
			}
	
		}}}
	


