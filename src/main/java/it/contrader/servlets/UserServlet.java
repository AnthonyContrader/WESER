package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private int userId;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String choice = request.getParameter("action");
		final HttpSession session = request.getSession(true);

		switch (choice) {

		case "UsersList":
			allUsers = this.usersServiceDTO.getAllUsers();
			request.setAttribute("allUsers", allUsers);
			getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
			break;			

		case "Insert":
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String usertype = request.getParameter("user_type");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String ssc = request.getParameter("cf");
			final UserDTO users = new UserDTO(username,usertype, password,name,surname,ssc);
			usersService.insertUser(users);
			showAllUser(request, response);
			break;
					
		case "Update":
			System.out.println("Insert the user id to update: "+Integer.parseInt(request.getParameter("userId")));
			System.out.println("Insert new username: "+request.getParameter("username"));
			System.out.println("Insert new user type: "+request.getParameter("usertype"));
			System.out.println("Insert new password: "+request.getParameter("password"));
			System.out.println("Insert new name: "+request.getParameter("name"));
			System.out.println("Insert new surname: "+request.getParameter("surname"));
			System.out.println("Insert new Social Security Number: "+request.getParameter("ssc"));

		     	
			final String usernameUpdate = request.getParameter("username");
			final String usertypeUpdate = request.getParameter("usertype");
			final String passwordUpdate = request.getParameter("password");
			final String nameUpdate = request.getParameter("name");
			final String surnameUpdate = request.getParameter("surname");
			final String sscUpdate = request.getParameter("ssc");
			final UserDTO user = new UserDTO(usernameUpdate,usertypeUpdate, passwordUpdate, nameUpdate, surnameUpdate, sscUpdate);
					
							
			usersService.updateUser(user);
			showAllUser(request, response);
			break;

		case "Delete":
			final Integer idDelete = Integer.parseInt(request.getParameter("userId"));
			
			final UserDTO use = new UserDTO("" ,"","","","","");
			usersService.delete(userId);
			showAllUser(request, response);
			break;

		case "Back":
			response.sendRedirect("index.jsp");
			break;

				}

			}

	private void showAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			allUsers = this.usersServiceDTO.getAllUsers();
			request.getSession().setAttribute("usersList", allUsers);
			getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);

		}
}
