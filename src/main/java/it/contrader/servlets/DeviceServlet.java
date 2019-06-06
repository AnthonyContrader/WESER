package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.DeviceDTO;
import it.contrader.service.DeviceServiceDTO;


@SuppressWarnings("serial")
public class DeviceServlet extends HttpServlet {

	private final DeviceServiceDTO deviceServiceDTO = new DeviceServiceDTO();
	private List<DeviceDTO> allDevices = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "DeviceManager":
			allDevices = this.deviceServiceDTO.getAllDevices();
			request.setAttribute("allDevice", allDevices);
			getServletContext().getRequestDispatcher("/device/manageDevice.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/device/insertDevice.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("device_id"));
			final String devicename = request.getParameter("devicename");
			final String devicetype = request.getParameter("device_type");
			final String password = request.getParameter("password");
			final String name = request.getParameter("name");
			final String surname = request.getParameter("surname");
			final String cf = request.getParameter("cf");
			final DeviceDTO devices = new DeviceDTO(devicename,devicetype, password, name,surname,cf);
			deviceServiceDTO.insertDevices(devices);
			showAllDevices(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			DeviceDTO deviceUpdate = new DeviceDTO("", "", "","","","");
			deviceUpdate.setId(id);

			deviceUpdate = this.deviceServiceDTO.readDevice(deviceUpdate);
			request.setAttribute("deviceUpdate", deviceUpdate);
			getServletContext().getRequestDispatcher("/device/updateDevice.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("device_id")));
			//System.out.println("devicename: " + request.getParameter("device_device"));
			//System.out.println("password: " + request.getParameter("device_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("device_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("device_id"));
			final String devicenameUpdate = request.getParameter("devicename");
			final String devicetypeUpdate= request.getParameter("device_type");
			final String passwordUpdate = request.getParameter("password");
			final String nameUpdate = request.getParameter("name");
			final String surnameUpdate = request.getParameter("surname");
			final String cfUpdate = request.getParameter("cf");
			final DeviceDTO device = new DeviceDTO(devicenameUpdate,devicetypeUpdate, passwordUpdate, nameUpdate,surnameUpdate,cfUpdate);
			device.setId(idUpdate);

			deviceServiceDTO.updateDevice(device);
			showAllDevices(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final DeviceDTO devicedelete = new DeviceDTO("", "", "","","","");
			devicedelete.setId(deleteId);
			deviceServiceDTO.deleteDevices(devicedelete);
			showAllDevices(request, response);
			break;

		case "indietro":
			getServletContext().getRequestDispatcher("JspApp/homeAdmin.jsp").forward(request, response);

			break;

		case "logsMenu":
			getServletContext().getRequestDispatcher("JspApp/index.jsp").forward(request, response);
			break;

		}

	}

	private void showAllDevices(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allDevices = this.deviceServiceDTO.getAllDevices();
		request.setAttribute("allDevice", allDevices);
		getServletContext().getRequestDispatcher("/device/manageDevice.jsp").forward(request, response);
	}
}