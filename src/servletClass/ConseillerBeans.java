package servletClass;

import java.util.ArrayList;
import java.util.Vector;

import metier.Conseiller;

public class ConseillerBeans {

	private Conseiller conseiller = new Conseiller(0, null, null, null, null, null);
	private ArrayList<Conseiller> liste = new ArrayList<Conseiller>();

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public ArrayList<Conseiller> getListe() {
		return liste;
	}

	public void setListe(ArrayList arrayList) {
		this.liste = arrayList;
	}

}
