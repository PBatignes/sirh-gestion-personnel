package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class EditerCollaborateurController extends HttpServlet {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService depService = Constantes.DEPS_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("matricule") == null) {

			resp.setStatus(400);
			resp.getWriter().write("Erreur : Un matricule est attendu");

		} else {
			List<Collaborateur> listeCollabs = collabService.listerCollaborateurs();
			List<Collaborateur> editCollab = new ArrayList<>();
			for (Collaborateur collab : listeCollabs) {
				if (req.getParameter("matricule").equals(collab.getMatricule())) {
					editCollab.add(collab);
				}
			}

			req.setAttribute("matricule", req.getParameter("matricule"));
			req.setAttribute("listeCollabs", listeCollabs);
			req.setAttribute("listeCollabs", editCollab);
			req.setAttribute("listeDep", depService.listerDepartement());
			req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Collaborateur> listeCollabs = collabService.listerCollaborateurs();
		int indice = -1;
		for (int i = 0; i < listeCollabs.size(); i++) {

			if (req.getParameter("matricule").equals(listeCollabs.get(i).getMatricule())) {
				indice = i;
			}

		}

		listeCollabs.get(indice).setIntitulePoste(req.getParameter("intitulePoste"));
		List<Departement> listDep = depService.listerDepartement();
		if (req.getParameter("departement") != null) {
			for (int i = 0; i < listDep.size(); i++) {

				if (req.getParameter("departement").equals(listDep.get(i).getNom())) {
					listeCollabs.get(indice).setDepartement(listDep.get(i));
				}

			}
			
		}
		listeCollabs.get(indice).setAdresse(req.getParameter("adresse"));
		listeCollabs.get(indice).setNumTel(req.getParameter("numTel"));
		listeCollabs.get(indice).setBanque(req.getParameter("banque"));
		listeCollabs.get(indice).setBic(req.getParameter("bic"));
		listeCollabs.get(indice).setIban(req.getParameter("iban"));

		req.setAttribute("listeCollabs", listeCollabs);
		req.setAttribute("listeDep", depService.listerDepartement());
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);

	}

}
