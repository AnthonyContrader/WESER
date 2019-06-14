package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PatologyDTO;
import it.contrader.services.PatologyService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Patology")
public class PatologyController {

	private final PatologyService patologyService;
	
	@Autowired
	public PatologyController(PatologyService patologyService) {
		this.patologyService = patologyService;
	}

	@RequestMapping(value = "/patologyManagement", method = RequestMethod.GET)
	public List<PatologyDTO> patologyManagement() {
		// PatologyDTO patologyDTOPatologyList = new PatologyDTO();
		// patologyDTOPatologyList.setPatologyId(patologyId);
		return this.patologyService.findAllPatologyDTO();
	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public PatologyDTO read(@RequestParam(value = "patologyId") int id) {
			PatologyDTO readPatology = new PatologyDTO();
			readPatology = this.patologyService.getPatologyDTOById(id);
			return readPatology;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "patologyId") int id) {
			this.patologyService.deletePatologyById(id);
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody PatologyDTO patology) {
			patologyService.updatePatology(patology);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody PatologyDTO patology) {
			patologyService.insertPatology(patology);
		}
	
}