package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	
	public List<Departement> listerDepartement() {
		
		List<Departement> listeDepartement = new ArrayList<>();
		listeDepartement.add(new Departement(1, "Comptabilite"));
		listeDepartement.add(new Departement(2, "RessourcesHumaines"));
		listeDepartement.add(new Departement(3, "Informatique"));
		listeDepartement.add(new Departement(4, "Administratif"));
		
		return listeDepartement;
		
	}
	
	

}
