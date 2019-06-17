package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.ReadingDTO;
import it.contrader.services.ReadingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


@CrossOrigin
@Controller
@RequestMapping("/Reading")
public class ReadingController {

	private final ReadingService readingService;
	private HttpSession session;
	
	@Autowired
	public ReadingController(ReadingService readingService) {
		this.readingService = readingService;
	}

	@RequestMapping(value = "/readingManagement", method = RequestMethod.GET)
	public String readingManagement(HttpServletRequest request) {
		request.setAttribute("reading", getReadings());
	return "reading/readingManagement";
	}
	
	public List<ReadingDTO> getReadings() {
		List<ReadingDTO> tmp = readingService.getListaReadingDTO();
	List<ReadingDTO> readingList = new ArrayList<>();
		for (ReadingDTO reading : tmp) {
			if (reading.getPatcf() != "") {
			readingList.add(reading);
			}
	}

		return readingList;
	}
		
	@RequestMapping(value ="/deleteReading", method = RequestMethod.GET)
	public String deleteReading(HttpServletRequest request) {
		int idReading = Integer.parseInt(request.getParameter("id"));
		readingService.deleteReadingById(idReading);
		request.setAttribute("reading", getReadings());
		return "reading/readingManagement";
	}
		
//	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
//	public String redirectUpdate(HttpServletRequest request) {
//		int idReading = Integer.parseInt(request.getParameter("id"));
//		ReadingDTO reading = readingService.getReadingDTOById(idReading);
//		request.setAttribute("reading", reading);
//		return "updateReading";
//	}
//	
//	@RequestMapping(value = "/updateReading", method = RequestMethod.POST)
//	public String updateReading(HttpServletRequest request)
//	{
//		int idUpdate = Integer.parseInt(request.getParameter("id"));
//		String patcfUpdate = request.getParameter("patcf");
//		String regdevUpdate = request.getParameter("regdev");
//		int minpressUpdate =  Integer.parseInt(request.getParameter("minpress"));
//		int maxpressUpdate =  Integer.parseInt(request.getParameter("maxpress"));
//		int mincirUpdate =  Integer.parseInt(request.getParameter("mincir"));
//		int maxcirUpdate =  Integer.parseInt(request.getParameter("maxcir"));
//		int minbreathUpdate =  Integer.parseInt(request.getParameter("minbreath"));
//		int maxbreathUpdate =  Integer.parseInt(request.getParameter("maxbreath"));
//		float mintempUpdate =  Float.parseFloat(request.getParameter("mintemp"));
//		float maxtempUpdate =  Float.parseFloat(request.getParameter("maxtemp"));
//		Date periodUpdate = Date.from();
//		
//		final ReadingDTO reading = new ReadingDTO(patcfUpdate,regdevUpdate,minpressUpdate,maxpressUpdate, mincirUpdate,maxcirUpdate, minbreathUpdate, maxbreathUpdate,mintempUpdate,maxtempUpdate,periodUpdate);
//		reading.setId(idUpdate);
//		
//		readingService.updateReading(reading);
//		request.setAttribute("reading", getReadings());
//		return "readingManagement";	
//		
//	}

		@RequestMapping(value = "/insertReading", method = RequestMethod.POST)
		public String insertReading(HttpServletRequest request) {
			
			String patcf = request.getParameter("patcf");
			String regdev = request.getParameter("regdev");
			int minpress =  Integer.parseInt(request.getParameter("minpress"));
			int maxpress =  Integer.parseInt(request.getParameter("maxpress"));
			int cir =  Integer.parseInt(request.getParameter("cir"));
			int breath =  Integer.parseInt(request.getParameter("breath"));
			float temp =  Float.parseFloat(request.getParameter("temp"));
			String giornora = request.getParameter("giornora");
			
			
			ReadingDTO readingDTO = new ReadingDTO(patcf,regdev,minpress,maxpress,cir,breath,temp,giornora);
			
			readingService.insertReading(readingDTO);
			
			request.setAttribute("reading", getReadings());
			
			return "reading/readingManagement";		
		}
		
//		@RequestMapping(value = "/logout", method = RequestMethod.GET)
//		public void logOut() {
//			// request.getSession().invalidate();
//			// return "index";
//		}
	
	
}