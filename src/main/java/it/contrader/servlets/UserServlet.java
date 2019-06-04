package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.converter.ConverterUser;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class UserServlet extends HttpServlet {
	
	private final UserService usersService = new UserService();


	private final UserService usersServiceDTO = new UserService();
	private List<UserDTO> allUsers= new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String choice = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (choice) {

		case "userList":
			allUsers = this.usersServiceDTO.getAllUsers();
			request.setAttribute("allUsers", allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
			break;			

		case "insert":
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String usertype = request.getParameter("user_type");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String ssc = request.getParameter("cf");
			final UserDTO users = new UserDTO(username,usertype, password,name,surname,ssc);
			usersService.insertUser(users);
			showAllUsers(request, response);
			break;
					
		case "update":
			System.out.println("Insert the user id to update: "+Integer.parseInt(request.getParameter("userid")));
			System.out.println("Insert new username: "+request.getParameter("username"));
			System.out.println("Insert new user type: "+request.getParameter("usertype"));
			System.out.println("Insert new password: "+request.getParameter("password"));
			System.out.println("ruolo: "+request.getParameter("ruolo"));

		     	
			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String ruoloUpdate = request.getParameter("ruolo");
			final UsersDTO user = new UsersDTO(idUpdate, usernameUpdate,passwordUpdate, ruoloUpdate);
					
				
					
			usersServiceDTO.updateUsers(user);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer idUpdat = Integer.parseInt(request.getParameter("id"));
			
			final UsersDTO use = new UsersDTO(idUpdat,"" ,"","");
			usersServiceDTO.deleteUsers(use);
			showAllUsers(request, response);
			break;

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("homeLogs.jsp");
			break;

				}

			}

		

	

private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	allUsers = this.usersServiceDTO.getAllUsers();
	request.setAttribute("allUsers", allUsers);
	getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
}
}
