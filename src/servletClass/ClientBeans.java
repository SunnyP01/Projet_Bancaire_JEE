package servletClass;

import java.util.ArrayList;
import java.util.Vector;

import metier.Client;

public class ClientBeans {

	private Client client = new Client(0, null, null, null, null, 0);
	private ArrayList<Client> liste = new ArrayList<Client>();
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ArrayList<Client> getListe() {
		return liste;
	}
	public void setListe(ArrayList arrayList) {
		this.liste = arrayList;
	}
	
	

}
