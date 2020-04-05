package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Collaborateur {

	/** Matricule */
	String matricule;
	/** nom */
	String nom;
	/** prenom */
	String prenom;
	/** date de Naissance */
	LocalDate dateNaissance;
	/** adresse */
	String adresse;
	/** numéro de sécurité socialle */
	String numSecu;
	/** email professionnel */
	String emailPro;
	/** photo */
	String photo;
	/** date et heure de creation */
	ZonedDateTime dateHeureCreation;
	/** actif */
	Boolean actif;
	/** intitulePoste */
	String intitulePoste;
	/** departement */
	Departement departement;
	/** numTel */
	String numTel;
	/** banque */
	String banque;
	/** bic */
	String bic;
	/** iban */
	String iban;

	/**Constructor
	 *
	 */
	public Collaborateur() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 * @param numSecu
	 * @param emailPro
	 * @param photo
	 * @param dateHeureCreation
	 * @param actif
	 */
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateNaissance, String adresse,
			String numSecu, String photo, ZonedDateTime dateHeureCreation, Boolean actif) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		genererEmail();
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.actif = actif;
	}

	/**
	 * Getter
	 *
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 *
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 *
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 *
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter
	 *
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter
	 *
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter
	 *
	 * @return the numSecu
	 */
	public String getNumSecu() {
		return numSecu;
	}

	/**
	 * Setter
	 *
	 * @param numSecu the numSecu to set
	 */
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	/**
	 * Getter
	 *
	 * @return the emailPro
	 */
	public String getEmailPro() {
		return emailPro;
	}

	/**
	 * Setter
	 *
	 * @param emailPro the emailPro to set
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	/**
	 * Getter
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter
	 *
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Getter
	 *
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * Setter
	 *
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * Getter
	 *
	 * @return the actif
	 */
	public Boolean getActif() {
		return actif;
	}

	/**
	 * Setter
	 *
	 * @param actif the actif to set
	 */
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	private void genererEmail() {

		String email = this.prenom + "." + this.nom + "@societe.com";
		this.setEmailPro(email);

	}

	/**
	 * Getter
	 *
	 * @return the intitulePoste
	 */
	public String getIntitulePoste() {
		return intitulePoste;
	}

	/**
	 * Setter
	 *
	 * @param intitulePoste the intitulePoste to set
	 */
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	/**
	 * Getter
	 *
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * Setter
	 *
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/**
	 * Getter
	 *
	 * @return the numTel
	 */
	public String getNumTel() {
		return numTel;
	}

	/**
	 * Setter
	 *
	 * @param numTel the numTel to set
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	/**Getter
	 *
	 * @return the banque
	 */
	public String getBanque() {
		return banque;
	}

	/**Setter
	 *
	 * @param banque the banque to set
	 */
	public void setBanque(String banque) {
		this.banque = banque;
	}

	/**Getter
	 *
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}

	/**Setter
	 *
	 * @param bic the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}

	/**Getter
	 *
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**Setter
	 *
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

}
