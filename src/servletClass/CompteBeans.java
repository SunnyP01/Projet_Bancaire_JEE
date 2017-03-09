package servletClass;

import java.util.ArrayList;
import java.util.Vector;

import metier.Compte;

public class CompteBeans {
	
	private Compte compte = new Compte();
	private ArrayList<Compte> liste = new ArrayList<Compte>();
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public ArrayList<Compte> getListe() {
		return liste;
	}
	public void setListe(ArrayList arrayList) {
		this.liste = arrayList;
	}
	
	

}
