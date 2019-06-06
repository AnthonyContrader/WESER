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
import it.contrader.service.UserServiceDTO;


@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	private final UserServiceDTO userServiceDTO = new UserServiceDTO();
	private List<UserDTO> allUsers = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "UserManager":
			allUsers = this.userServiceDTO.getAllUsers();
			request.setAttribute("allUser", allUsers);
			getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/user/insertUser.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final String username = request.getParameter("username");
			final String usertype = request.getParameter("user_type");
			final String password = request.getParameter("password");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String cf = request.getParameter("cf");
			final UserDTO users = new UserDTO(username,usertype, password, name,surname,cf);
			userServiceDTO.insertUsers(users);
			showAllUsers(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			UserDTO userUpdate = new UserDTO("", "", "","","","");
			userUpdate.setId(id);

			userUpdate = this.userServiceDTO.readUser(userUpdate);
			request.setAttribute("userUpdate", userUpdate);
			getServletContext().getRequestDispatcher("/user/updateUser.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));
			//System.out.println("username: " + request.getParameter("user_user"));
			//System.out.println("password: " + request.getParameter("user_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String usernameUpdate = request.getParameter("username");
			final String usertypeUpdate= request.getParameter("user_type");
			final String passwordUpdate = request.getParameter("password");
			final String nameUpdate = request.getParameter("name");
			final String surnameUpdate = request.getParameter("surname");
			final String cfUpdate = request.getParameter("cf");
			final UserDTO user = new UserDTO(usernameUpdate,usertypeUpdate, passwordUpdate, nameUpdate,surnameUpdate,cfUpdate);
			user.setId(idUpdate);

			userServiceDTO.updateUser(user);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final UserDTO userdelete = new UserDTO("", "", "","","","");
			userdelete.setId(deleteId);
			userServiceDTO.deleteUsers(userdelete);
			showAllUsers(request, response);
			break;

		case "indietro":
			getServletContext().getRequestDispatcher("JspApp/homeAdmin.jsp").forward(request, response);

			break;

		case "logsMenu":
			getServletContext().getRequestDispatcher("JspApp/index.jsp").forward(request, response);
			break;

		}

	}

	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allUsers = this.userServiceDTO.getAllUsers();
		request.setAttribute("allUser", allUsers);
		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
}