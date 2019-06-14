package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

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

//	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
//	public List<UserDTO> userManagement() {
//		// UserDTO userDTOUserList = new UserDTO();
//		// userDTOUserList.setUserId(userId);
//		return this.userService.findAllUserDTO();
//	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public UserDTO read(@RequestParam(value = "iduser") int id) {
			UserDTO readUser = new UserDTO();
			readUser = this.userService.getUserDTOById(id);
			return readUser;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "iduser") int id) {
			this.userService.deleteUserById(id);
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody UserDTO user) {
			userService.updateUser(user);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody UserDTO user) {
			userService.insertUser(user);
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
					  
				  default: return "index";
				  	}
				 
			}
			return "index";
		}

		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public void logOut() {
			// request.getSession().invalidate();
			// return "index";
		}
	
	
}