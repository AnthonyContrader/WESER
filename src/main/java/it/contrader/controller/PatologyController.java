package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.PatologyDTO;
import it.contrader.services.PatologyService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Patology")
public class PatologyController {

	private final PatologyService patologyService;
	private HttpSession session;

	@Autowired
	public PatologyController(PatologyService patologyService) {
		this.patologyService = patologyService;
	}

	@RequestMapping(value = "/patologyManagement", method = RequestMethod.GET)
	public String patologyManagement(HttpServletRequest request) {
		request.setAttribute("patology", getPatologys());
		return "patology/patologyManagement";
	}

	public List<PatologyDTO> getPatologys() {
		List<PatologyDTO> tmp = patologyService.getListaPatologyDTO();
		List<PatologyDTO> patologyList = new ArrayList<>();
		for (PatologyDTO patology : tmp) {
			if (patology.getPato() != "") {
				patologyList.add(patology);
			}
		}

		return patologyList;
	}


	@RequestMapping(value ="/deletePatology", method = RequestMethod.GET)
	public String deletePatology(HttpServletRequest request) {
		int idPatology = Integer.parseInt(request.getParameter("id"));
		patologyService.deletePatologyById(idPatology);
		request.setAttribute("patology", getPatologys());
		return "patology/patologyManagement";
	}
	
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idPatology = Integer.parseInt(request.getParameter("id"));
		PatologyDTO patology = patologyService.getPatologyDTOById(idPatology);
		request.setAttribute("patology", patology);
		return "patology/updatePatology";
	}
	
	@RequestMapping(value = "/updatePatology", method = RequestMethod.POST)
	public String updatePatology(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String patoUpdate = request.getParameter("pato");
		String carenameUpdate = request.getParameter("carename");
		String patcfUpdate = request.getParameter("patcf");
		String quantityUpdate = request.getParameter("quantity");
		int patominpressUpdate = Integer.parseInt(request.getParameter("patominpress"));
		int patomaxpressUpdate = Integer.parseInt(request.getParameter("patomaxpress"));
		int patomincirUpdate = Integer.parseInt(request.getParameter("patomincir"));
		int patomaxcirUpdate = Integer.parseInt(request.getParameter("patomaxcir"));
		int patominbreathUpdate = Integer.parseInt(request.getParameter("patominbreath"));
		int patomaxbreathUpdate = Integer.parseInt(request.getParameter("patomaxbreath"));
		float patomintempUpdate = Float.parseFloat(request.getParameter("patomintemp"));
		float patomaxtempUpdate = Float.parseFloat(request.getParameter("patomaxtemp"));
		
		final PatologyDTO patology = new PatologyDTO(patoUpdate,carenameUpdate,patcfUpdate,quantityUpdate,patominpressUpdate,patomaxpressUpdate,patomincirUpdate,patomaxcirUpdate,patominbreathUpdate,patomaxbreathUpdate,patomintempUpdate,patomaxtempUpdate);
		patology.setId(idUpdate);
		
		patologyService.updatePatology(patology);
		request.setAttribute("patology", getPatologys());
		return "patology/patologyManagement";	
		
	}
	
	
	@RequestMapping(value = "/insertPatology", method = RequestMethod.POST)
	public String insertPatology(HttpServletRequest request) {
		String pato = request.getParameter("pato");
		String carename = request.getParameter("carename");
		String patcf = request.getParameter("patcf");
		String quantity = request.getParameter("quantity");
		int patominpress = Integer.parseInt(request.getParameter("patominpress"));
		int patomaxpress = Integer.parseInt(request.getParameter("patomaxpress"));
		int patomincir = Integer.parseInt(request.getParameter("patomincir"));
		int patomaxcir = Integer.parseInt(request.getParameter("patomaxcir"));
		int patominbreath = Integer.parseInt(request.getParameter("patominbreath"));
		int patomaxbreath = Integer.parseInt(request.getParameter("patomaxbreath"));
		float patomintemp = Float.parseFloat(request.getParameter("patomintemp"));
		float patomaxtemp = Float.parseFloat(request.getParameter("patomaxtemp"));
		
		PatologyDTO patologyDTO = new PatologyDTO(pato,carename,patcf,quantity,patominpress,patomaxpress,patomincir,patomaxcir,patominbreath,patomaxbreath,patomintemp,patomaxtemp);
		
		patologyService.insertPatology(patologyDTO);
		
		request.setAttribute("patology", getPatologys());
		
		return "patology/patologyManagement";		
	}
	
	}

