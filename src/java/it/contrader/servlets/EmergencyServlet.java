package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.EmergencyDTO;
import it.contrader.service.EmergencyServiceDTO;


public class EmergencyServlet extends HttpServlet {

	private final EmergencyServiceDTO emergencyServiceDTO = new EmergencyServiceDTO();
	private List<EmergencyDTO> allEmergencys = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "EmergencyManager":
			allEmergencys = this.emergencyServiceDTO.getAllEmergencys();
			request.setAttribute("allEmergency", allEmergencys);
			getServletContext().getRequestDispatcher("/emergency/manageEmergency.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/emergency/insertEmergency.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("emergency_id"));
			final String emnum = request.getParameter("emnum");
			final EmergencyDTO emergencys = new EmergencyDTO(emnum);
			emergencyServiceDTO.insertEmergencys(emergencys);
			showAllEmergencys(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("emId"));
			EmergencyDTO emergencyUpdate = new EmergencyDTO("");
			emergencyUpdate.setEmId(id);

			emergencyUpdate = this.emergencyServiceDTO.readEmergency(emergencyUpdate);
			request.setAttribute("emergencyUpdate", emergencyUpdate);
			getServletContext().getRequestDispatcher("/emergency/updateEmergency.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("emergency_id")));
			//System.out.println("emergencyname: " + request.getParameter("emergency_emergency"));
			//System.out.println("password: " + request.getParameter("emergency_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("emergency_type"));

			final Integer emIdUpdate = Integer.parseInt(request.getParameter("emId"));
			final String emnumUpdate = request.getParameter("emnum");
			final EmergencyDTO emergency = new EmergencyDTO(emnumUpdate);
			emergency.setEmId(emIdUpdate);

			emergencyServiceDTO.updateEmergency(emergency);
			showAllEmergencys(request, response);
			break;

		case "delete":
			final Integer deleteemId = Integer.parseInt(request.getParameter("emId"));

			final EmergencyDTO emergencydelete = new EmergencyDTO("");
			emergencydelete.setEmId(deleteemId);
			emergencyServiceDTO.deleteEmergencys(emergencydelete);
			showAllEmergencys(request, response);
			break;

		case "indietro":
			getServletContext().getRequestDispatcher("homeAdmin.jsp").forward(request, response);

			break;

		case "logsMenu":
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
			break;

		}

	}

	private void showAllEmergencys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allEmergencys = this.emergencyServiceDTO.getAllEmergencys();
		request.setAttribute("allEmergency", allEmergencys);
		getServletContext().getRequestDispatcher("/emergency/manageEmergency.jsp").forward(request, response);
	}
}