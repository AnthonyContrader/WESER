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
public class UsersServlet extends HttpServlet {

	private final UserService usersService = new UserService();
	private List<UsersDTO> allUsers= new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String choice = request.getParameter("request");
		final HttpSession session = request.getSession(true);

		switch (choice) {

		case "userList":
			allUsers = this.usersService.getAllUser();
			request.setAttribute("allUsers", allUsers);
			getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
			break;			

		case "insert":
			final String username = request.getParameter("username");
			final String usertype = request.getParameter("user_type");
			final String password = request.getParameter("password");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String ssc = request.getParameter("cf");
			final UsersDTO users = new UsersDTO(username,usertype, password, name,surname,ssc);
			usersService.insertUser(users);
			showAllUsers(request, response);
			break;
					
		case "update":
			System.out.println("Inser the user id to update: "+Integer.parseInt(request.getParameter("userid")));
			System.out.println("Insert new username: "+request.getParameter("username"));
			System.out.println("Insert new user type: "+request.getParameter("usertype"));
			System.out.println("Insert new password: "+request.getParameter("password"));
			System.out.println("Insert new name: "+request.getParameter("name"));
			System.out.println("Insert new surname: "+request.getParameter("surname"));
			System.out.println("Insert new social security number: "+request.getParameter("ssc"));

		     	
			final Integer userid = Integer.parseInt(request.getParameter("user_id"));
			final String username = request.getParameter("username");
			final String usertype = request.getParameter("user_type");
			final String password = request.getParameter("password");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String ssc = request.getParameter("cf");
			final UsersDTO user = new UsersDTO(userid,username,usertype,password,name,surname, ssc);
					
				
					
			usersService.updateUser(user);
			showAllUsers(request, response);
			break;

		case "delete":
			System.out.println("Inser the user id to delete: "+Integer.parseInt(request.getParameter("userid")));
			
		     	
			final Integer userid = Integer.parseInt(request.getParameter("user_id"));
			
			
			usersService.deleteUser(Integer userid);
			showAllUsers(request, response);
			break;


		case "back":
			response.sendRedirect("home.jsp");
			break;

				}

			}

		

	

private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	allUsers = this.usersService.getAllUser();
	request.setAttribute("allUsers", allUsers);
	getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
}
}
