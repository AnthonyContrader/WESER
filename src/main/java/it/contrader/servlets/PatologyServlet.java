package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.PatologyDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PatologyServiceDTO;


@SuppressWarnings("serial")
public class PatologyServlet extends HttpServlet {

	private final PatologyServiceDTO patologyServiceDTO = new PatologyServiceDTO();
	private List<PatologyDTO> allPatologys = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "PatologyManager":
			allPatologys = this.patologyServiceDTO.getAllPatologys();
			request.setAttribute("allPatology", allPatologys);
			getServletContext().getRequestDispatcher("/patology/managePatology.jsp").forward(request, response);
			break;
			

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/patology/insertPatology.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("patology_id"));
			final String pato = request.getParameter("patology");
			final String carename = request.getParameter("carename");
			final String quantity = request.getParameter("quantity");
			final String patcf = request.getParameter("patcf");
			final int patominpress = Integer.parseInt(request.getParameter("patominpress"));
			final int patomaxpress = Integer.parseInt(request.getParameter("patomaxpress"));
			final int patomincir = Integer.parseInt(request.getParameter("patomincir"));
			final int patomaxcir = Integer.parseInt(request.getParameter("patomaxcir"));
			final int patominbreath = Integer.parseInt(request.getParameter("patominbreath"));
			final int patomaxbreath = Integer.parseInt(request.getParameter("patomaxbreath"));
			final float patomintemp = Float.parseFloat(request.getParameter("patomintemp"));
			final float patomaxtemp = Float.parseFloat(request.getParameter("patomaxtemp"));
			final PatologyDTO patologys = new PatologyDTO(pato,carename,quantity,patcf,patominpress,patomaxpress,patomincir,patomaxcir,patominbreath,patomaxbreath,patomintemp,patomaxtemp);
			patologyServiceDTO.insertPatologys(patologys);
			showAllPatologys(request, response);
			break;

		case "updateRedirect":
			int patologyid = Integer.parseInt(request.getParameter("id"));
			PatologyDTO patologyUpdate = new PatologyDTO("","","","",0,0,0,0,0,0,0,0);
			patologyUpdate.setPatologyid(patologyid);

			patologyUpdate = this.patologyServiceDTO.readPatology(patologyUpdate);
			request.setAttribute("patologyUpdate", patologyUpdate);
			getServletContext().getRequestDispatcher("/patology/updatePatology.jsp").forward(request, response);

			break;

		case "update":
			
			
			final String patoUpdate = request.getParameter("patology");
			final String carenameUpdate = request.getParameter("carename");
			final String quantityUpdate= request.getParameter("quantity");
			final String patcfUpdate = request.getParameter("patcf");
			final int patominpressUpdate = Integer.parseInt(request.getParameter("patominpress"));
			final int patomaxpressUpdate = Integer.parseInt(request.getParameter("patomaxpress"));
			final int patomincirUpdate = Integer.parseInt(request.getParameter("patomincir"));
			final int patomaxcirUpdate = Integer.parseInt(request.getParameter("patomaxcir"));
			final int patominbreathUpdate = Integer.parseInt(request.getParameter("patominbreath"));
			final int patomaxbreathUpdate = Integer.parseInt(request.getParameter("patomaxbreath"));
			final float patomintempUpdate = Float.parseFloat(request.getParameter("patomintemp"));
			final float patomaxtempUpdate = Float.parseFloat(request.getParameter("patomaxtemp"));
			final int patologyidUpdate = Integer.parseInt(request.getParameter("patologyid"));
			final PatologyDTO patology = new PatologyDTO(patoUpdate,carenameUpdate,quantityUpdate,patcfUpdate,patominpressUpdate,patomaxpressUpdate,patomincirUpdate,patomaxcirUpdate,patominbreathUpdate,patomaxbreathUpdate,patomintempUpdate,patomaxtempUpdate);
			patology.setPatologyid(patologyidUpdate);

			patologyServiceDTO.updatePatology(patology);
			showAllPatologys(request, response);
			break;

		case "delete":
			final Integer deletepatologyid = Integer.parseInt(request.getParameter("id"));

			final PatologyDTO patologydelete =  new PatologyDTO("", "", "","",0,0,0,0,0,0,0,0);
			patologydelete.setPatologyid(deletepatologyid);
			patologyServiceDTO.deletePatologys(patologydelete);
			showAllPatologys(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeDoctor.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;


		}

	}

	private void showAllPatologys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allPatologys = this.patologyServiceDTO.getAllPatologys();
		request.setAttribute("allPatology", allPatologys);
		getServletContext().getRequestDispatcher("/patology/managePatology.jsp").forward(request, response);
	}
}