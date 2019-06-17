package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.EmergencyDTO;
import it.contrader.services.EmergencyService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Emergency")
public class EmergencyController {

	private final EmergencyService emergencyService;
	private HttpSession session;

	@Autowired
	public EmergencyController(EmergencyService emergencyService) {
		this.emergencyService = emergencyService;
	}

	@RequestMapping(value = "/emergencyManagement", method = RequestMethod.GET)
	public String emergencyManagement(HttpServletRequest request) {
		request.setAttribute("emergency", getEmergencys());
		return "emergency/emergencyManagement";
	}

	public List<EmergencyDTO> getEmergencys() {
		List<EmergencyDTO> tmp = emergencyService.getListaEmergencyDTO();
		List<EmergencyDTO> emergencyList = new ArrayList<>();
		for (EmergencyDTO emergency : tmp) {
			if (emergency.getNum() != "") {
				emergencyList.add(emergency);
			}
		}

		return emergencyList;
	}


	@RequestMapping(value ="/deleteEmergency", method = RequestMethod.GET)
	public String deleteEmergency(HttpServletRequest request) {
		int idEmergency = Integer.parseInt(request.getParameter("id"));
		emergencyService.deleteEmergencyById(idEmergency);
		request.setAttribute("emergency", getEmergencys());
		return "emergency/emergencyManagement";
	}
	
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idEmergency = Integer.parseInt(request.getParameter("id"));
		EmergencyDTO emergency = emergencyService.getEmergencyDTOById(idEmergency);
		request.setAttribute("emergency", emergency);
		return "emergency/emergencyManagement";
	}
	
	@RequestMapping(value = "/updateEmergency", method = RequestMethod.POST)
	public String updateEmergency(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String numUpdate = request.getParameter("num");
		
		final EmergencyDTO emergency = new EmergencyDTO(numUpdate);
		emergency.setId(idUpdate);
		
		emergencyService.updateEmergency(emergency);
		request.setAttribute("emergency", getEmergencys());
		return "emergency/emergencyManagement";	
		
	}
	
	
	@RequestMapping(value = "/insertEmergency", method = RequestMethod.POST)
	public String insertEmergency(HttpServletRequest request) {
		
		String num= request.getParameter("num");
		
		
		EmergencyDTO emergencyDTO = new EmergencyDTO(num);
		
		emergencyService.insertEmergency(emergencyDTO);
		
		request.setAttribute("emergency", getEmergencys());
		
		return "emergency/emergencyManagement";		
	}
	
	}

