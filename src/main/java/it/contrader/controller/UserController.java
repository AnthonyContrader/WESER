package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		request.setAttribute("user", getUsers());
		return "user/userManagement";
	}

	public List<UserDTO> getUsers() {
		List<UserDTO> tmp = userService.getListaUserDTO();
		List<UserDTO> userList = new ArrayList<>();
		for (UserDTO user : tmp) {
			if (user.getUsertype() != "") {
				userList.add(user);
			}
		}

		return userList;
	}


	@RequestMapping(value ="/deleteUser", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(idUser);
		request.setAttribute("user", getUsers());
		return "user/userManagement";
	}
	
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("id"));
		UserDTO user = userService.getUserDTOById(idUser);
		request.setAttribute("user", user);
		return "user/updateUser";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		String usertypeUpdate = request.getParameter("usertype");
		String nameUpdate = request.getParameter("name");
		String surnameUpdate = request.getParameter("surname");
		String ssnUpdate = request.getParameter("ssn");
		
		final UserDTO user = new UserDTO(usernameUpdate,passwordUpdate,usertypeUpdate,nameUpdate,surnameUpdate,ssnUpdate);
		user.setId(idUpdate);
		
		userService.updateUser(user);
		request.setAttribute("user", getUsers());
		return "user/userManagement";	
		
	}
	
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String ssn = request.getParameter("ssn");
		
		
		UserDTO userDTO = new UserDTO(username,password,usertype,name,surname,ssn);
		
		userService.insertUser(userDTO);
		
		request.setAttribute("user", getUsers());
		
		return "user/userManagement";		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getUserByUsernameAndPassword(username, password);
		final String userType = userDTO.getUsertype();

		if (!StringUtils.isEmpty(userType)) {
			session.setAttribute("utenteCollegato", userDTO);

			switch (userType) {
			case "admin":
				session.setAttribute("utenteCollegato", userDTO);
				System.out.println(userDTO.getUsertype());

				return "homeAdmin";

			case "doctor":
				return "homeDoctor";

			case "tutor":
				return "homeTutor";

			default:
				return "index";
			}

		}
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

}