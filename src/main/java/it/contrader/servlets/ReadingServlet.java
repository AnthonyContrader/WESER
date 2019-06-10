package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ReadingDTO;
import it.contrader.service.ReadingServiceDTO;

public class ReadingServlet extends HttpServlet {

	private final ReadingServiceDTO readingServiceDTO = new ReadingServiceDTO();
	private List<ReadingDTO> allReadings = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "ReadingManager":
			allReadings = this.readingServiceDTO.getAllReadings();
			request.setAttribute("allReading", allReadings);
			getServletContext().getRequestDispatcher("/reading/manageReading.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/reading/insertReading.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("readid"));
			final String patcf = request.getParameter("patcf");
			final String regdev = request.getParameter("regdev");
			final int minpress = Integer.parseInt(request.getParameter("minpress"));
			final int maxpress = Integer.parseInt(request.getParameter("maxpress"));
			final int mincir = Integer.parseInt(request.getParameter("mincir"));
			final int maxcir = Integer.parseInt(request.getParameter("maxcir"));
			final int minbreath = Integer.parseInt(request.getParameter("minbreath"));
			final int maxbreath = Integer.parseInt(request.getParameter("maxbreath"));
			final float mintemp = Float.parseFloat(request.getParameter("mintemp"));
			final float maxtemp = Float.parseFloat(request.getParameter("maxtemp"));
			final ReadingDTO readings = new ReadingDTO(patcf, regdev, minpress, maxpress, mincir, maxcir, minbreath,
					maxbreath, mintemp, maxtemp);
			readingServiceDTO.insertReadings(readings);
			showAllReadings(request, response);
			break;

		case "delete":
			final int deleteId = Integer.parseInt(request.getParameter("id"));

			final ReadingDTO readingdelete = new ReadingDTO("", "", 0, 0, 0, 0, 0, 0, 0, 0);
			readingdelete.setReadId(deleteId);
			readingServiceDTO.deleteReadings(readingdelete);
			showAllReadings(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeDoctor.jsp");
			break;
		
		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllReadings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allReadings = this.readingServiceDTO.getAllReadings();
		request.setAttribute("allReading", allReadings);
		getServletContext().getRequestDispatcher("/reading/manageReading.jsp").forward(request, response);
	}
}