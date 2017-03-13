package metier;

import java.util.ArrayList;

public class Conseiller extends User {
	
	private ArrayList<Client> mesClients = new ArrayList<Client>();
	private int idConseiller;
	
	public Conseiller() {
		super();
		mesClients = null;
	}
	
	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public Conseiller(int id, String email, String nom, String prenom, String password, ArrayList<Client> mesClients) {
		super(id, email, nom, prenom, password);
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
