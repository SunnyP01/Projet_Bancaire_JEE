package metier;

import java.util.ArrayList;

public class Conseiller extends User {
	
	private ArrayList<Client> mesClients = new ArrayList<Client>();
	
	public Conseiller(String email, String nom, String prenom, String password, ArrayList<Client> mesClients) {
		super(email, nom, prenom, password);
		this.mesClients = mesClients;
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Client> getClients()
	{
		return this.mesClients;
	}
	
	public void setClient (Client monClient)
	{
		this.mesClients.add(monClient);
	}
	

}
