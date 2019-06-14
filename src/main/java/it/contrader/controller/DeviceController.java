package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DeviceDTO;
import it.contrader.services.DeviceService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Device")
public class DeviceController {

	private final DeviceService deviceService;
	
	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

//	@RequestMapping(value = "/deviceManagement", method = RequestMethod.GET)
//	public List<DeviceDTO> deviceManagement() {
//		// DeviceDTO deviceDTODeviceList = new DeviceDTO();
//		// deviceDTODeviceList.setDeviceId(deviceId);
//		return this.deviceService.findAllDeviceDTO();
//	}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public DeviceDTO read(@RequestParam(value = "deviceId") int id) {
			DeviceDTO readDevice = new DeviceDTO();
			readDevice = this.deviceService.getDeviceDTOById(id);
			return readDevice;
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "deviceId") int id) {
			this.deviceService.deleteDeviceById(id);
		}
		
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody DeviceDTO device) {
			deviceService.updateDevice(device);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody DeviceDTO device) {
			deviceService.insertDevice(device);
		}

//		@RequestMapping(value = "/login", method = RequestMethod.GET)
//		public DeviceDTO loginControl(@RequestParam(value = "devicename") String devicename,
//				@RequestParam(value = "password") String password) {
//
//			// session = request.getSession();
//			// final String devicename = request.getParameter("devicename");
//			// final String password = request.getParameter("password");
//			final DeviceDTO deviceDTO = deviceService.getDeviceByDevicenameAndPassword(devicename, password);
//			final String deviceType = deviceDTO.getDevicetype();
//			if (!StringUtils.isEmpty(deviceType)) {
//
//				// session.setAttribute("utente", deviceDTO);
//
//				/*
//				 * if (deviceType.equals("admin")) { return "home"; } else if
//				 * (deviceType.equals("bo")) { return "home"; }
//				 */
//				/*
//				 * switch (deviceType.toLowerCase()) { case "admin": return
//				 * "redirect:/Home/homeAdmin"; case "bo": return "redirect:/Home/homeBO";
//				 * default: return "index"; }
//				 */
//
//				return deviceDTO;
//
//			}
//
//			return null;
//			// return "index";
//		}


		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public void logOut() {
			// request.getSession().invalidate();
			// return "index";
		}
	
	
}