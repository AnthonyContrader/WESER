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
import it.contrader.services.CureService;
import it.contrader.services.DeviceService;
import it.contrader.services.ReadingService;
import it.contrader.services.UserService;


import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;
	private final CureService cureService;
	private final DeviceService deviceService;
	private final ReadingService readingService;
	
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
	HomeController(UserService userService, CureService cureService, DeviceService deviceService, ReadingService readingService) {
		this.userService=userService;
		this.cureService=cureService;
		this.deviceService=deviceService;
		this.readingService=readingService;
	}
	/*public HomeController(UserService userService, ClientService clientService, OrderService orderService,
			TaskService taskService, ProjectService projectService, ProjectTemplateService projectTemplateService,
			ResourceService resourceService) {
		this.userService = userService;
		this.clientService = clientService;
		this.orderService = orderService;
		this.taskService = taskService;
		this.projectService = projectService;
		this.projectTemplateService = projectTemplateService;
		this.resourceservice = resourceService;
	}*/

	
	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public String homeAdmin(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDeviceDTO", allDevice);
		return "homeAdmin.jsp";
		//return "homeAdmin";
	}

	
	@RequestMapping(value = "/homeTutor", method = RequestMethod.GET)
	public String homeTutor(HttpServletRequest request) {
		List<CureDTO> allCure = this.cureService.getListaCureDTO();
		request.setAttribute("allCureDTO", allCure);
		return "homeTutor.jsp";
	}

	@RequestMapping(value = "/homeDoctor", method = RequestMethod.GET)
	public String homeDoctor(HttpServletRequest request) {
		List<CureDTO> allCure = this.cureService.getListaCureDTO();	
		request.setAttribute("allCureDTO", allCure);
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDeviceDTO", allDevice);
		return "homeDoctor.jsp";
	}
}
