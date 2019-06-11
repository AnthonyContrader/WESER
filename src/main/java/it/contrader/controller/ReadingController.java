package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ReadingDTO;
import it.contrader.services.ReadingService;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Controller
@RequestMapping("/Reading")
public class ReadingController {

	private final ReadingService readingService;
	private HttpSession session;
	
	@Autowired
	public ReadingController(ReadingService readingService) {
		this.readingService = readingService;
	}

	private void visualReading(HttpServletRequest request){
		List<ReadingDTO> allReading = this.readingService.getListaReadingDTO();
		request.setAttribute("allReadingDTO", allReading);
	}
	
	@RequestMapping(value = "/readingManagement", method = RequestMethod.GET)
	public String readingManagement(HttpServletRequest request) {
		visualReading(request);
		return "homeReading";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.readingService.deleteReadingById(id);
		visualReading(request);
		return "homeReading";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualReading(request);
		request.setAttribute("option", "insert");
		return "insertReading";
		
	}
	
	@RequestMapping(value = "/searchReading", method = RequestMethod.GET)
	public String searchReading(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<ReadingDTO> allReading = this.readingService.findReadingDTOById(content);
		request.setAttribute("allReadingDTO", allReading);

		return "homeReading";

	}
	
	@RequestMapping(value = "/insertReading", method = RequestMethod.POST)
	public String insertReading(HttpServletRequest request) {
		String patcf = request.getParameter("patcf").toString();
		String regdev = request.getParameter("regdev").toString();
		int minpress = Integer.parseInt(request.getParameter("minpress").toString());
		int maxpress = Integer.parseInt(request.getParameter("maxpress").toString());
		int mincir = Integer.parseInt(request.getParameter("mincir").toString());
		int maxcir = Integer.parseInt(request.getParameter("maxcir").toString());
		int minbreath = Integer.parseInt(request.getParameter("minbreath").toString());
		int maxbreath = Integer.parseInt(request.getParameter("maxbreath").toString());
		float mintemp = Float.parseFloat(request.getParameter("mintemp").toString());
		float maxtemp = Float.parseFloat(request.getParameter("maxtemp").toString());
		Date period = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		
		ReadingDTO readingObj = new ReadingDTO(0, patcf, regdev, minpress, maxpress, mincir, maxcir, minbreath, maxbreath, mintemp, maxtemp, period);
		
		readingService.insertReading(readingObj);

		visualReading(request);
		return "homeReading";
	}
	
}
