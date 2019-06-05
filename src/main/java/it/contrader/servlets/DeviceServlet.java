package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.converter.ConverterDevice;
import it.contrader.dto.DeviceDTO;
import it.contrader.service.DeviceService;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà Device dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class DeviceServlet extends HttpServlet {
	
	private final DeviceService devicesService = new DeviceService();


	private final DeviceService devicesServiceDTO = new DeviceService();
	private List<DeviceDTO> allDevices= new ArrayList<>();
	private int DevId;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String choice = request.getParameter("action");
		final HttpSession session = request.getSession(true);

		switch (choice) {

		case "Devices List":
			allDevices = this.devicesServiceDTO.getAllDevice();
			request.setAttribute("allDevices", allDevices);
			getServletContext().getRequestDispatcher("/Devices.jsp").forward(request, response);
			break;			

		case "Insert":
			final String regnumber = request.getParameter("reg_number");
			final String devtype = request.getParameter("dev_type");
			final String description = request.getParameter("description");
			final int minpress = Integer.parseInt(request.getParameter("min_press"));
			final int maxpress = Integer.parseInt(request.getParameter("max_press"));
			final int mincir = Integer.parseInt(request.getParameter("min_cir"));
			final int maxcir = Integer.parseInt(request.getParameter("max_cir"));
			final int minbreath = Integer.parseInt(request.getParameter("min_breath"));
			final int maxbreath = Integer.parseInt(request.getParameter("max_breath"));
			final float mintemp = Integer.parseInt(request.getParameter("min_temp"));
			final float maxtemp = Integer.parseInt(request.getParameter("max_temp"));
			final DeviceDTO Devices = new DeviceDTO(regnumber, devtype, description, minpress, maxpress, mincir, maxcir, minbreath, maxbreath, mintemp, maxtemp);
			devicesService.insertDevice(Devices);
			showAllDevice(request, response);
			break;
					
		case "Update":
			System.out.println("Insert the device id to update: "+Integer.parseInt(request.getParameter("DevId")));
			System.out.println("Insert new registration number: "+request.getParameter("regnumber"));
			System.out.println("Insert new device type: "+request.getParameter("devtype"));
			System.out.println("Insert new description: "+request.getParameter("description"));
			System.out.println("Insert new min pressure: "+request.getParameter("minpress"));
			System.out.println("Insert new max pressure: "+request.getParameter("maxpress"));
			System.out.println("Insert new min heartbeats: "+request.getParameter("mincir"));
			System.out.println("Insert new max heartbeats: "+request.getParameter("maxcir"));
			System.out.println("Insert new min breath: "+request.getParameter("minbreath"));
			System.out.println("Insert new max breath: "+request.getParameter("maxbreath"));
			System.out.println("Insert new min temperature: "+request.getParameter("mintemp"));
			System.out.println("Insert new max temperature: "+request.getParameter("maxtemp"));

		     	
			final String regnumberUpdate = request.getParameter("reg_number");
			final String devtypeUpdate = request.getParameter("dev_type");
			final String descriptionUpdate = request.getParameter("description");
			final int minpressUpdate = Integer.parseInt(request.getParameter("min_press"));
			final int maxpressUpdate = Integer.parseInt(request.getParameter("max_press"));
			final int mincirUpdate = Integer.parseInt(request.getParameter("min_cir"));
			final int maxcirUpdate = Integer.parseInt(request.getParameter("max_cir"));
			final int minbreathUpdate = Integer.parseInt(request.getParameter("min_breath"));
			final int maxbreathUpdate = Integer.parseInt(request.getParameter("max_breath"));
			final float mintempUpdate = Integer.parseInt(request.getParameter("min_temp"));
			final float maxtempUpdate = Integer.parseInt(request.getParameter("max_temp"));
			final DeviceDTO Device = new DeviceDTO(regnumberUpdate, devtypeUpdate, descriptionUpdate, minpressUpdate, maxpressUpdate, mincirUpdate, maxcirUpdate, minbreathUpdate, maxbreathUpdate, mintempUpdate, maxtempUpdate);
					
							
			devicesService.updateDevice(Device);
			showAllDevice(request, response);
			break;

		case "Delete":
			final Integer idDelete = Integer.parseInt(request.getParameter("DevId"));
			
			final DeviceDTO use = new DeviceDTO("" ,"","","","","","","","","","");
			devicesService.deleteDevice(DevId);
			showAllDevice(request, response);
			break;

		case "Back":
			response.sendRedirect("index.jsp");
			break;

				}

			}

	private void showAllDevice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			allDevices = this.devicesServiceDTO.getAllDevice();
			request.getSession().setAttribute("Devices_list", allDevices);
			getServletContext().getRequestDispatcher("/Devices.jsp").forward(request, response);

		}
}
