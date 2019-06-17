package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.DeviceDTO;
import it.contrader.services.DeviceService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Device")
public class DeviceController {

	
		private final DeviceService deviceService;
		
		private HttpSession session;
	
		@Autowired
		public DeviceController( DeviceService deviceService) {
			this.deviceService =deviceService;
		}
	
		@RequestMapping(value = "/deviceManagement", method = RequestMethod.GET)
		public String deviceManagement(HttpServletRequest request) {
			request.setAttribute("device", getDevices());
			return "device/deviceManagement";
		}
	
		@RequestMapping(value = "/deviceManagementD", method = RequestMethod.GET)
		public String deviceManagementD(HttpServletRequest request) {
			request.setAttribute("device", getDevices());
			return "device/deviceManagementD";
		}
	
		
		public List<DeviceDTO> getDevices() {
			List<DeviceDTO> tmp = deviceService.getListaDeviceDTO();
			List<DeviceDTO> deviceList = new ArrayList<>();
			for (DeviceDTO device : tmp) {
				if (!(device.getId()==0)) {
					deviceList.add(device);
				}
			}
	
			return deviceList;
		}
	
	
		@RequestMapping(value ="/deleteDevice", method = RequestMethod.GET)
		public String deleteDevice(HttpServletRequest request) {
			int idDev = Integer.parseInt(request.getParameter("id"));
			deviceService.deleteDeviceById(idDev);
			request.setAttribute("device", getDevices());
			return "device/deviceManagement";
		}
		
		
		@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
		public String redirectUpdate(HttpServletRequest request) {
			int idDev = Integer.parseInt(request.getParameter("id"));
			DeviceDTO device = deviceService.getDeviceDTOById(idDev);
			request.setAttribute("device", device);
			return "device/updateDevice";
		}
		
		@RequestMapping(value = "/updateDevice", method = RequestMethod.POST)
		public String updateDevice(HttpServletRequest request)
		{
			int idUpdate = Integer.parseInt(request.getParameter("id"));
			String regUpdate = request.getParameter("regnum");
			String typeUpdate = request.getParameter("devtype");
			String descUpdate = request.getParameter("descr");
			int mincirUpdate = Integer.parseInt(request.getParameter("mincir"));
			int maxcirUpdate = Integer.parseInt(request.getParameter("maxcir"));
			int minpresUpdate = Integer.parseInt(request.getParameter("minpress"));
			int maxpresUpdate = Integer.parseInt(request.getParameter("maxpress"));
			int minbreathUpdate = Integer.parseInt(request.getParameter("minbreath"));
			int maxbreathUpdate = Integer.parseInt(request.getParameter("maxbreath"));
			float mintempUpdate = Float.parseFloat(request.getParameter("mintemp"));
			float maxtempUpdate = Float.parseFloat(request.getParameter("maxtemp"));
			
			
			final DeviceDTO device = new DeviceDTO(regUpdate,typeUpdate,descUpdate,mincirUpdate,maxcirUpdate,minpresUpdate,maxpresUpdate,minbreathUpdate,maxbreathUpdate,mintempUpdate,maxtempUpdate);
			device.setId(idUpdate);
			
			deviceService.updateDevice(device);
			request.setAttribute("device", getDevices());
			return "device/deviceManagement";	
			
		}
		
		
		@RequestMapping(value = "/insertDevice", method = RequestMethod.POST)
		public String insertDevice(HttpServletRequest request) {
			String reg = request.getParameter("regnum");
			String type = request.getParameter("devtype");
			String descr = request.getParameter("descr");
			int mincir = Integer.parseInt(request.getParameter("mincir"));
			int maxcir = Integer.parseInt(request.getParameter("maxcir"));
			int minpress = Integer.parseInt(request.getParameter("minpress"));
			int maxpress = Integer.parseInt(request.getParameter("maxpress"));
			int minbreath = Integer.parseInt(request.getParameter("minbreath"));
			int maxbreath = Integer.parseInt(request.getParameter("maxbreath"));
			float mintemp = Float.parseFloat(request.getParameter("mintemp"));
			float maxtemp = Float.parseFloat(request.getParameter("maxtemp"));
			
			
			DeviceDTO deviceDTO = new DeviceDTO(reg,type,descr,mincir,maxcir,minpress,maxpress,minbreath,maxbreath,mintemp,maxtemp);
			
			deviceService.insertDevice(deviceDTO);
			
			request.setAttribute("device", getDevices());
			
			return "device/deviceManagement";		
		}
	
	}

	