package metier;

public class User {
	
	private String email, nom, prenom, password;
	private int id;
	
	public User() {
		id = 0;
		email = null;
		nom = null;
		prenom = null;
		password = null;
	}
	
	public User(int id, String email, String nom, String prenom, String password) {
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public User(String email, String nom, String prenom, String password) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
