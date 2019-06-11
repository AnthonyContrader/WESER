package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.EmergencyDTO;
import it.contrader.services.EmergencyService;

import java.util.List;


@Controller
@RequestMapping("/Emergency")
public class EmergencyController {

	private final EmergencyService emergencyService;
	private HttpSession session;
	
	@Autowired
	public EmergencyController(EmergencyService emergencyService) {
		this.emergencyService = emergencyService;
	}

	private void visualEmergency(HttpServletRequest request){
		List<EmergencyDTO> allEmergency = this.emergencyService.getListaEmergencyDTO();
		request.setAttribute("allEmergencyDTO", allEmergency);
	}
	
	@RequestMapping(value = "/emergencyManagement", method = RequestMethod.GET)
	public String emergencyManagement(HttpServletRequest request) {
		visualEmergency(request);
		return "homeTutor";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.emergencyService.deleteEmergencyById(id);
		visualEmergency(request);
		return "homeTutor";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualEmergency(request);
		request.setAttribute("option", "insert");
		return "insertEmergency";
		
	}
	
	@RequestMapping(value = "/searchEmergency", method = RequestMethod.GET)
	public String cercaEmergency(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<EmergencyDTO> allEmergency = this.emergencyService.findEmergencyDTOById(content);
		request.setAttribute("allEmergencyDTO", allEmergency);

		return "homeTutor";

	}
	
	@RequestMapping(value = "/insertEmergency", method = RequestMethod.POST)
	public String insertEmergency(HttpServletRequest request) {
		String emnum = request.getParameter("emnum").toString();

		EmergencyDTO emergencyObj = new EmergencyDTO(0,emnum);
		
		emergencyService.insertEmergency(emergencyObj);

		visualEmergency(request);
		return "homeTutor";
	}
	

}
