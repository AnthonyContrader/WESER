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

import it.contrader.dto.CureDTO;
import it.contrader.services.CureService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Cure")
public class CureController {

	private final CureService cureService;
	
	@Autowired
	public CureController(CureService cureService) {
		this.cureService = cureService;
	}

//	@RequestMapping(value = "/cureManagement", method = RequestMethod.GET)
//	public List<CureDTO> cureManagement() {
//		// CureDTO cureDTOCureList = new CureDTO();
//		// cureDTOCureList.setCureId(cureId);
//		return this.cureService.findAllCureDTO();
//	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public CureDTO read(@RequestParam(value = "cureId") int id) {
			CureDTO readCure = new CureDTO();
			readCure = this.cureService.getCureDTOById(id);
			return readCure;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "cureId") int id) {
			this.cureService.deleteCureById(id);
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody CureDTO cure) {
			cureService.updateCure(cure);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody CureDTO cure) {
			cureService.insertCure(cure);
		}

//		@RequestMapping(value = "/logout", method = RequestMethod.GET)
//		public void logOut() {
//			// request.getSession().invalidate();
//			// return "index";
//		}
	
	
}