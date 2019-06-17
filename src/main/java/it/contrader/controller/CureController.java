package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.CureDTO;
import it.contrader.services.CureService;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@Controller
@RequestMapping("/Cure")
public class CureController {

	private final CureService cureService;
	private HttpSession session;
	
	@Autowired
	public CureController(CureService cureService) {
		this.cureService = cureService;
	}

	@RequestMapping(value = "/cureManagement", method = RequestMethod.GET)
	public String cureManagement(HttpServletRequest request) {
		request.setAttribute("cure", getCures());
	return "cure/cureManagement";
	}
	
	@RequestMapping(value = "/cureManagementT", method = RequestMethod.GET)
	public String cureManagementT(HttpServletRequest request) {
		request.setAttribute("cure", getCures());
	return "cure/cureManagementT";
	}
	
	public List<CureDTO> getCures() {
		List<CureDTO> tmp = cureService.getListaCureDTO();
	List<CureDTO> cureList = new ArrayList<>();
		for (CureDTO cure : tmp) {
			if (cure.getCurename() != "") {
			cureList.add(cure);
			}
	}

		return cureList;
	}
		
	@RequestMapping(value ="/deleteCure", method = RequestMethod.GET)
	public String deleteCure(HttpServletRequest request) {
		int idCure = Integer.parseInt(request.getParameter("id"));
		cureService.deleteCureById(idCure);
		request.setAttribute("cure", getCures());
		return "cure/cureManagement";
	}
		
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idCure = Integer.parseInt(request.getParameter("id"));
		CureDTO cure = cureService.getCureDTOById(idCure);
		request.setAttribute("cure", cure);
		return "cure/updateCure";
	}
	
	@RequestMapping(value = "/updateCure", method = RequestMethod.POST)
	public String updateCure(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String patnameUpdate = request.getParameter("patname");
		String patcfUpdate = request.getParameter("patcf");
		int patageUpdate =  Integer.parseInt(request.getParameter("patage"));
		String patoUpdate = request.getParameter("pato");
		String curenameUpdate = request.getParameter("curename");
		String quantityUpdate = request.getParameter("quantity");
		String notesUpdate = request.getParameter("notes");
		
		final CureDTO cure = new CureDTO(patnameUpdate,patcfUpdate,patageUpdate,patoUpdate,curenameUpdate,quantityUpdate,notesUpdate);
		cure.setId(idUpdate);
		
		cureService.updateCure(cure);
		request.setAttribute("cure", getCures());
		return "cure/cureManagement";	
		
	}

		@RequestMapping(value = "/insertCure", method = RequestMethod.POST)
		public String insertCure(HttpServletRequest request) {
			
			String patname= request.getParameter("patname");
			String patcf = request.getParameter("patcf");
			int patage =  Integer.parseInt(request.getParameter("patage"));
			String pato = request.getParameter("pato");
			String curename = request.getParameter("curename");
			String quantity = request.getParameter("quantity");
			String notes = request.getParameter("notes");
			
			
			CureDTO cureDTO = new CureDTO(patname,patcf,patage,pato,curename,quantity,notes);
			
			cureService.insertCure(cureDTO);
			
			request.setAttribute("cure", getCures());
			
			return "cure/cureManagement";		
		}
	
}