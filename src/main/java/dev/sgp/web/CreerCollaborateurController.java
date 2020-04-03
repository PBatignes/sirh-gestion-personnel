package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class CreerCollaborateurController extends HttpServlet{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setAttribute("erreurNumSecu", "");
		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("numSecu").length() != 15) {
			
			req.setAttribute("erreurNumSecu", "Le numéro de sécurité social doit avoir 15 caractères");
			req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp").forward(req, resp);
			
		} else {
			
			Collaborateur collab = new Collaborateur(Long.toHexString(Double.doubleToLongBits(Math.random())),
					req.getParameter("nom"), 
					req.getParameter("prenom"), 
					LocalDate.parse(req.getParameter("dateNaiss")), 
					req.getParameter("adresse"), 
					req.getParameter("numSecu"), 
					req.getParameter("photo"), 
					ZonedDateTime.now(), 
					true);
			
			collabService.sauvegarderCollaborateur(collab);
			req.getRequestDispatcher("/collaborateurs/lister").forward(req, resp);
			
		}
		
		
		
	}

	

}
