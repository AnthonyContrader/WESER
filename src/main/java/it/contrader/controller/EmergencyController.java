package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.EmergencyDTO;
import it.contrader.services.EmergencyService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Emergency")
public class EmergencyController {

	private final EmergencyService emergencyService;
	
	@Autowired
	public EmergencyController(EmergencyService emergencyService) {
		this.emergencyService = emergencyService;
	}
//
//	@RequestMapping(value = "/emergencyManagement", method = RequestMethod.GET)
//	public List<EmergencyDTO> emergencyManagement() {
//		// EmergencyDTO emergencyDTOEmergencyList = new EmergencyDTO();
//		// emergencyDTOEmergencyList.setEmergencyId(emergencyId);
//		return this.emergencyService.findAllEmergencyDTO();
//	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public EmergencyDTO read(@RequestParam(value = "emergencyId") int id) {
			EmergencyDTO readEmergency = new EmergencyDTO();
			readEmergency = this.emergencyService.getEmergencyDTOById(id);
			return readEmergency;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "emergencyId") int id) {
			this.emergencyService.deleteEmergencyById(id);
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody EmergencyDTO emergency) {
			emergencyService.updateEmergency(emergency);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody EmergencyDTO emergency) {
			emergencyService.insertEmergency(emergency);
		}

}