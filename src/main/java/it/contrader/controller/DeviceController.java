package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DeviceDTO;
import it.contrader.services.DeviceService;

import java.util.List;


@Controller
@RequestMapping("/Device")
public class DeviceController {

	private final DeviceService deviceService;
	private HttpSession session;
	
	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	private void visualDevice(HttpServletRequest request){
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDeviceDTO", allDevice);
	}
	
	@RequestMapping(value = "/deviceManagement", method = RequestMethod.GET)
	public String deviceManagement(HttpServletRequest request) {
		visualDevice(request);
		return "homeDevice";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.deviceService.deleteDeviceById(id);
		visualDevice(request);
		return "homeDevice";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualDevice(request);
		request.setAttribute("option", "insert");
		return "insertDevice";
		
	}
	
	@RequestMapping(value = "/searchDevice", method = RequestMethod.GET)
	public String searchDevice(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<DeviceDTO> allDevice = this.deviceService.findDeviceDTOById(content);
		request.setAttribute("allDeviceDTO", allDevice);

		return "homeDevice";

	}
	
	@RequestMapping(value = "/insertDevice", method = RequestMethod.POST)
	public String insertDevice(HttpServletRequest request) {
		String regnumber = request.getParameter("regnumber").toString();
		String devtype = request.getParameter("devtype").toString();
		String description = request.getParameter("description").toString();
		int minpress = Integer.parseInt(request.getParameter("minpress").toString());
		int maxpress = Integer.parseInt(request.getParameter("maxpress").toString());
		int mincir = Integer.parseInt(request.getParameter("mincir").toString());
		int maxcir = Integer.parseInt(request.getParameter("maxcir").toString());
		int minbreath = Integer.parseInt(request.getParameter("minbreath").toString());
		int maxbreath = Integer.parseInt(request.getParameter("maxbreath").toString());
		float mintemp = Float.parseFloat(request.getParameter("mintemp").toString());
		float maxtemp = Float.parseFloat(request.getParameter("maxtemp").toString());
		
		DeviceDTO deviceObj = new DeviceDTO(0, regnumber, devtype, description, minpress, maxpress, mincir, maxcir, minbreath, maxbreath, mintemp, maxtemp);
		
		deviceService.insertDevice(deviceObj);

		visualDevice(request);
		return "homeDevice";
	}
	
}
