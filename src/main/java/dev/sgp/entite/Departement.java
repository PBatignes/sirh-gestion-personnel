package dev.sgp.entite;

/**
 *
 * @author Pierre
 *
 */
public class Departement {
	
	/** id */
	Integer id;
	/** nom */
	String nom;
	
	/**Constructor
	 *
	 * @param id
	 * @param nom
	 */
	public Departement(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	/**Getter
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**Setter
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**Getter
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**Setter
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
