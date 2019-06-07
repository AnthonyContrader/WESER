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
			final String regnumber = request.getParameter("regnumber");
			final String devtype = request.getParameter("devtype");
			final String description = request.getParameter("description");
			final int minpress = Integer.parseInt(request.getParameter("minpress"));
			final int maxpress = Integer.parseInt(request.getParameter("maxpress"));
			final int mincirr = Integer.parseInt(request.getParameter("mincir"));
			final int maxcirr = Integer.parseInt(request.getParameter("maxcir"));
			final int minbreath = Integer.parseInt(request.getParameter("minbreath"));
			final int maxbreath = Integer.parseInt(request.getParameter("maxbreath"));
			final float mintemp = Float.parseFloat(request.getParameter("mintemp"));
			final float maxtemp = Float.parseFloat(request.getParameter("maxtemp"));
			final DeviceDTO devices = new DeviceDTO(regnumber,devtype, description, minpress,maxpress,mincirr,maxcirr,minbreath,maxbreath,mintemp,maxtemp);
			deviceServiceDTO.insertDevices(devices);
			showAllDevices(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			DeviceDTO deviceUpdate = new DeviceDTO("", "", "",0,0,0,0,0,0,0,0);
			deviceUpdate.setDevId(id);

			deviceUpdate = this.deviceServiceDTO.readDevice(deviceUpdate);
			request.setAttribute("deviceUpdate", deviceUpdate);
			getServletContext().getRequestDispatcher("/device/updateDevice.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("device_id")));
			//System.out.println("devicename: " + request.getParameter("device_device"));
			//System.out.println("password: " + request.getParameter("device_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("device_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("devId"));
			final String regnumberUpdate = request.getParameter("regnumber");
			final String devtypeUpdate = request.getParameter("devtype");
			final String descriptionUpdate = request.getParameter("description");
			final int minpressUpdate = Integer.parseInt(request.getParameter("minpress"));
			final int maxpressUpdate = Integer.parseInt(request.getParameter("maxpress"));
			final int mincirrUpdate = Integer.parseInt(request.getParameter("mincir"));
			final int maxcirrUpdate = Integer.parseInt(request.getParameter("maxcir"));
			final int minbreathUpdate = Integer.parseInt(request.getParameter("minbreath"));
			final int maxbreathUpdate = Integer.parseInt(request.getParameter("maxbreath"));
			final float mintempUpdate = Float.parseFloat(request.getParameter("mintemp"));
			final float maxtempUpdate = Float.parseFloat(request.getParameter("maxtemp"));
			final DeviceDTO device = new DeviceDTO(regnumberUpdate,devtypeUpdate, descriptionUpdate, minpressUpdate,maxpressUpdate,mincirrUpdate,maxcirrUpdate,minbreathUpdate,maxbreathUpdate,mintempUpdate,maxtempUpdate);
			device.setDevId(idUpdate);

			deviceServiceDTO.updateDevice(device);
			showAllDevices(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final DeviceDTO devicedelete =  new DeviceDTO("", "", "",0,0,0,0,0,0,0,0);
			devicedelete.setDevId(deleteId);
			deviceServiceDTO.deleteDevices(devicedelete);
			showAllDevices(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;
		case "indietroD":
			response.sendRedirect("homeDoctor.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
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