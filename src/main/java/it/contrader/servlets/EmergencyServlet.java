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
import it.contrader.dto.PaymentDTO;
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
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final String emnum = request.getParameter("emnum");
			final EmergencyDTO emergencys = new EmergencyDTO(emnum);
			emergencyServiceDTO.insertEmergency(emergencys);
			showAllEmergencys(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			EmergencyDTO emergencyUpdate = new EmergencyDTO("");
			emergencyUpdate.setEmId(id);

			emergencyUpdate = this.emergencyServiceDTO.readEmergency(emergencyUpdate);
			request.setAttribute("emergencyUpdate", emergencyUpdate);
			getServletContext().getRequestDispatcher("/emergency/updateEmergency.jsp").forward(request, response);

			break;

		case "update":
			
			final int emergencyIdUpdate = Integer.parseInt(request.getParameter("emId"));
			final String emnumUpdate = request.getParameter("emnum");
			final EmergencyDTO emergency = new EmergencyDTO(emnumUpdate);
			emergency.setEmId(emergencyIdUpdate);

			emergencyServiceDTO.updateEmergency(emergency);
			showAllEmergencys(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final EmergencyDTO emergencyDelete = new EmergencyDTO("");
			emergencyDelete.setEmId(deleteId);
			emergencyServiceDTO.deleteEmergency(emergencyDelete);
			showAllEmergencys(request, response);
			break;


		case "indietro":
			response.sendRedirect("homeTutor.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
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