package metier;

import java.sql.Date;

public class Compte {

	private Long id;
	private String nom;
	private String dateOuverture;
	private int idClient;
	private String solde;

	public Compte() {
		super();
	}

	public Compte(Long id, String nom, String dateOuverture, String solde, int idClient) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateOuverture = dateOuverture;
		this.solde = solde;
		this.idClient = idClient;
	}

	// Méthode GET
	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getSolde() {
		return solde;
	}

	// Méthode SET
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	// Affichage
	public String toString() {
		return id + " - " + nom + " - " + dateOuverture + " - " + idClient;
	}

	public void show() {
		System.out.println(toString());
	}

}
