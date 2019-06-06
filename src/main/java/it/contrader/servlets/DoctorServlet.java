package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.*;

import it.contrader.service.DoctorServiceDTO;


public class DoctorServlet extends HttpServlet {

	private final DoctorServiceDTO doctorServiceDTO = new DoctorServiceDTO();
	private List<DoctorDTO> allDoctors = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "CareManager":
			allDoctors = this.doctorServiceDTO.getAllDoctors();
			request.setAttribute("allDoctor", allDoctors);
			getServletContext().getRequestDispatcher("/care/manageCare.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/care/insertCare.jsp").forward(request, response);
			break;

		case "insert":
			final Integer id = Integer.parseInt(request.getParameter("doctor_id"));
			final String patname = request.getParameter("patname");
			final String patcf = request.getParameter("patcf");
			final int patage = Integer.parseInt(request.getParameter("patage"));
			final String patology = request.getParameter("patology");
			final String carename = request.getParameter("carename");
			final String quantity = request.getParameter("quantity");
			final String notes = request.getParameter("notes");
			final DoctorDTO doctors = new DoctorDTO(patname,patcf, patage, patology,carename,quantity,notes);
			doctorServiceDTO.insertDoctors(doctors);
			showAllDoctors(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			DoctorDTO doctorUpdate = new DoctorDTO("","",0,"","","","");
			doctorUpdate.setCareid(id);

			doctorUpdate = this.doctorServiceDTO.readDoctor(doctorUpdate);
			request.setAttribute("doctorUpdate", doctorUpdate);
			getServletContext().getRequestDispatcher("/care/updateCare.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("doctor_id")));
			//System.out.println("doctorname: " + request.getParameter("doctor_doctor"));
			//System.out.println("password: " + request.getParameter("doctor_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("doctor_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("doctor_id"));
			final String patnameUpdate = request.getParameter("patname");
			final String patcfUpdate= request.getParameter("patcf");
			final Integer patageUpdate = Integer.parseInt(request.getParameter("patage"));
			final String patologyUpdate = request.getParameter("patology");
			final String carenameUpdate = request.getParameter("carename");
			final String quantityUpdate = request.getParameter("quantity");
			final String noteUpdate = request.getParameter("notes");
			final DoctorDTO doctor = new DoctorDTO(patnameUpdate,patcfUpdate, patageUpdate, patologyUpdate,carenameUpdate,quantityUpdate,noteUpdate);
			doctor.setCareid(idUpdate);

			doctorServiceDTO.updateDoctor(doctor);
			showAllDoctors(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final DoctorDTO doctordelete = new DoctorDTO("", "", 0,"","","","");
			doctordelete.setCareid(deleteId);
			doctorServiceDTO.deleteDoctors(doctordelete);
			showAllDoctors(request, response);
			break;

		case "indietro":
			getServletContext().getRequestDispatcher("homeAdmin.jsp").forward(request, response);

			break;

		case "logsMenu":
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
			break;

		}

	}

	private void showAllDoctors(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allDoctors = this.doctorServiceDTO.getAllDoctors();
		request.setAttribute("allDoctor", allDoctors);
		getServletContext().getRequestDispatcher("/care/manageCare.jsp").forward(request, response);
	}
}