package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("matricule") == null) {

			resp.setStatus(400);
			resp.getWriter().write("Erreur : Un matricule est attendu");

		} else {

			String matricule = req.getParameter("matricule");
			resp.getWriter()
					.write("<h1>Edition de collaborateur</h1>" + "</br>" + "<p>Matricule : " + matricule + "</p>");

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String erreurMessage = "Les paramètres suivants sont incorrects : </br> <ul>";
		String erreurMatricule = "";
		String erreurTitre = "";
		String erreurNom = "";
		String erreurPrenom = "";
		boolean erreur = false;

		if (req.getParameter("matricule") == null) {

			erreurMatricule = "<li>Matricule</li>";
			erreur = true;

		}
		if (req.getParameter("titre") == null) {

			erreurTitre = "<li>Titre</li>";
			erreur = true;

		}
		if (req.getParameter("nom") == null) {

			erreurNom = "<li>Nom</li>";
			erreur = true;

		}
		if (req.getParameter("prenom") == null) {

			erreurPrenom = "<li>Prénom</li>";
			erreur = true;

		}

		erreurMessage += "</ul>";
		
		if (erreur) {
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects : </br> "
					+ "<ul>"
						+ erreurMatricule + erreurTitre + erreurNom + erreurPrenom);
			
		} else {
			
			resp.setStatus(201);
			resp.getWriter().write("Creation d’un collaborateur avec les informations suivantes : </br> "
					+ "<ul>"
						+ "<li>Matricule : " + req.getParameter("matricule") + "</li>"
						+ "<li>Titre : " + req.getParameter("titre") + "</li>"
						+ "<li>Nom : " + req.getParameter("nom") + "</li>"
						+ "<li>Prénom : " + req.getParameter("prenom") + "</li>"
					+"</ul>");
			
		}

	}

}
