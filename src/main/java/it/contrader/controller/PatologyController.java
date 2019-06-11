package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.PatologyDTO;
import it.contrader.services.PatologyService;

import java.util.List;


@Controller
@RequestMapping("/Patology")
public class PatologyController {

	private final PatologyService patologyService;
	private HttpSession session;
	
	@Autowired
	public PatologyController(PatologyService patologyService) {
		this.patologyService = patologyService;
	}

	private void visualPatology(HttpServletRequest request){
		List<PatologyDTO> allPatology = this.patologyService.getListaPatologyDTO();
		request.setAttribute("allPatologyDTO", allPatology);
	}
	
	@RequestMapping(value = "/patologyManagement", method = RequestMethod.GET)
	public String patologyManagement(HttpServletRequest request) {
		visualPatology(request);
		return "homeDoctor";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.patologyService.deletePatologyById(id);
		visualPatology(request);
		return "homeDoctor";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualPatology(request);
		request.setAttribute("option", "insert");
		return "insertPatology";
		
	}
	
	@RequestMapping(value = "/searchPatology", method = RequestMethod.GET)
	public String cercaPatology(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<PatologyDTO> allPatology = this.patologyService.findPatologyDTOById(content);
		request.setAttribute("allPatologyDTO", allPatology);

		return "homeDoctor";

	}
	
	@RequestMapping(value = "/insertPatology", method = RequestMethod.POST)
	public String insertPatology(HttpServletRequest request) {
		String pato = request.getParameter("pato").toString();
		String carename = request.getParameter("carename").toString();
		String patcf = request.getParameter("patcf").toString();
		String quantity = request.getParameter("quantity");
		int patominpress = Integer.parseInt(request.getParameter("patominpress"));
		int patomaxpress = Integer.parseInt(request.getParameter("patomaxpress"));
		int patomincir = Integer.parseInt(request.getParameter("patomincir"));
		int patomaxcir = Integer.parseInt(request.getParameter("patomaxcir"));
		int patominbreath = Integer.parseInt(request.getParameter("patominbreath"));
		int patomaxbreath = Integer.parseInt(request.getParameter("patomaxbreath"));
		float patomintemp = Float.parseFloat(request.getParameter("patomintemp"));
		float patomaxtemp = Float.parseFloat(request.getParameter("patomaxbreath"));

		PatologyDTO patologyObj = new PatologyDTO();
		
		patologyService.insertPatology(patologyObj);

		visualPatology(request);
		return "homePatology";
	}
	
}
