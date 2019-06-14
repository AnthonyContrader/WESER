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

import it.contrader.dto.ReadingDTO;
import it.contrader.services.ReadingService;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Reading")
public class ReadingController {

	private final ReadingService readingService;
	
	@Autowired
	public ReadingController(ReadingService readingService) {
		this.readingService = readingService;
	}

//	@RequestMapping(value = "/readingManagement", method = RequestMethod.GET)
//	public List<ReadingDTO> readingManagement() {
//		// ReadingDTO readingDTOReadingList = new ReadingDTO();
//		// readingDTOReadingList.setReadingId(readingId);
//		return this.readingService.findAllReadingDTO();
//	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public ReadingDTO read(@RequestParam(value = "readingId") int id) {
			ReadingDTO readReading = new ReadingDTO();
			readReading = this.readingService.getReadingDTOById(id);
			return readReading;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "readingId") int id) {
			this.readingService.deleteReadingById(id);
		}
		
//		@RequestMapping(value = "/update", method = RequestMethod.PUT)
//		public void update(@RequestBody ReadingDTO reading) {
//			readingService.updateReading(reading);
//		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody ReadingDTO reading) {
			readingService.insertReading(reading);
		}


		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public void logOut() {
			// request.getSession().invalidate();
			// return "index";
		}
	
	
}