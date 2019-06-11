package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CureDTO;
import it.contrader.dto.DeviceDTO;
import it.contrader.services.CureService;

import java.util.List;


@Controller
@RequestMapping("/Cure")
public class CureController {

	private final CureService cureService;
	private HttpSession session;
	
	@Autowired
	public CureController(CureService cureService) {
		this.cureService = cureService;
	}

	private void visualCure(HttpServletRequest request){
		List<CureDTO> allCure = this.cureService.getListaCureDTO();
		request.setAttribute("allCureDTO", allCure);
	}
	
	@RequestMapping(value = "/cureManagement", method = RequestMethod.GET)
	public String cureManagement(HttpServletRequest request) {
		visualCure(request);
		return "homeCure";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.cureService.deleteCureById(id);
		visualCure(request);
		return "homeCure";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualCure(request);
		request.setAttribute("option", "insert");
		return "insertCure";
		
	}
	
	@RequestMapping(value = "/searchCure", method = RequestMethod.GET)
	public String searchCure(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<CureDTO> allCure = this.cureService.findCureDTOById(content);
		request.setAttribute("allCureDTO", allCure);

		return "homeCure";

	}
	
	@RequestMapping(value = "/insertCure", method = RequestMethod.POST)
	public String insertCure(HttpServletRequest request) {
		String patname = request.getParameter("patname").toString();
		String patcf = request.getParameter("patcf").toString();
		Integer patage = Integer.parseInt(request.getParameter("patage"));
		String pato = request.getParameter("pato").toString();
		String carename = request.getParameter("carename").toString();
		String quantity = request.getParameter("quantity").toString();
		String notes = request.getParameter("notes").toString();
		
	    CureDTO cureObj = new CureDTO(0, patname, patcf, patage, pato, carename, quantity, notes);
		
		cureService.insertCure(cureObj);

		visualCure(request);
		return "homeCure";
	}
	
	
}
