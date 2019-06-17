package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.*;

import it.contrader.services.DeviceService;
import it.contrader.services.UserService;


import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;
	private final DeviceService deviceService;
	
//	@Autowired
//	private ProjectService projectService;
//	
//	/*
//	private final ClientService clientService;
//	private final OrderService orderService;
//	private final TaskService taskService;
//	private final ProjectService projectService;
//	private final ProjectTemplateService projectTemplateService;
//	private final ResourceService resourceservice;
//*/
	private HttpSession session;

	@Autowired
	
	public HomeController(UserService userService, DeviceService deviceService) {
		this.userService = userService;
		this.deviceService = deviceService;
	}

	
	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public String homeAdmin(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDeviceDTO", allDevice);
		return "homeAdmin.jsp";
	}

	
	@RequestMapping(value = "/homeTutor", method = RequestMethod.GET)
	public String homeTutor(HttpServletRequest request) {
		//List<CureDTO> allCure = this.cureService.getListaCureDTO();
		//request.setAttribute("allCureDTO", allCure);
		return "homeTutor.jsp";
	}

	@RequestMapping(value = "/homeDoctor", method = RequestMethod.GET)
	public String homeDoctor(HttpServletRequest request) {
	//	List<CureDTO> allCure = this.cureService.getListaCureDTO();	
		//request.setAttribute("allCureDTO", allCure);
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDeviceDTO", allDevice);
		return "homeDoctor.jsp";
	}
}
