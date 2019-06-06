package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.service.UserServiceDTO;
import it.contrader.dto.UserDTO;

public class LoginServlet extends HttpServlet {

	private final UserServiceDTO usersServiceDTO = new UserServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String nomeUtente = request.getParameter("username").toString().trim();
			final String password = request.getParameter("password").toString().trim();
			final UserDTO userDTO = usersServiceDTO.getUserByUsernameAndPasword(nomeUtente, password);

			if (userDTO != null)
				session.setAttribute("utente", userDTO);

			switch (userDTO.getUsertype().toLowerCase()) {
			case "admin":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;
			case "tutor":
				getServletContext().getRequestDispatcher("/homeTutor.jsp").forward(request, response);
				break;
			case "dotor":
				getServletContext().getRequestDispatcher("/homeDoctor.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}

}
