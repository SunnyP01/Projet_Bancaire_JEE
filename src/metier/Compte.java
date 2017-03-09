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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public String toString(){
		return id + " - " + nom + " - " + dateOuverture + " - " + idClient;	
	}
	
	public void show(){
		System.out.println(toString());
	}
	public String getSolde() {
		return solde;
	}
	public void setSolde(String solde) {
		this.solde = solde;
	}

}
