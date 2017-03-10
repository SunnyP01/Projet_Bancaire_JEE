package metier;

public class Client extends User{

	private int idConseiller;
	
	public Client(String email, String nom, String prenom, String password, int idConseiller) {
		super(email, nom, prenom, password);
		// TODO Auto-generated constructor stub
		this.idConseiller = idConseiller;
	}
	
	public int getIdConseiller()
	{
		return this.idConseiller;
	}
	
	public void setIdConseiller(int idConseiller)
	{
		this.idConseiller = idConseiller;
	}
}
