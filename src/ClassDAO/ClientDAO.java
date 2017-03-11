package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

import metier.Client;
import metier.Conseiller;

public class ClientDAO {
	
	public void addConseiller(int idClient, int idConseiller){
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    String maRequeteUpdate = "UPDATE client "
					+ " SET idConseiller = " + idConseiller 
					+" WHERE id = " + idClient;
		    
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement(maRequeteUpdate);
		    
		    System.out.println(maRequeteUpdate);
			pr.executeUpdate();
			System.out.println("Affectation d'un conseiller à un client");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Client> getAllClient() throws SQLException{
		ArrayList<Client> listClients = new ArrayList<Client>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM client c, user u "
		    																+ "WHERE c.idUser = u.id");
			ResultSet rs = pr.executeQuery();
			pr.execute();
			
			while(rs.next()){
				Client c = new Client(rs.getString("email"),rs.getString("nom"),rs.getString("prenom"),rs.getString("password"), 0);
				//c.setId(rs.getLong("id"));
				//c.setId(rs.getInt("idUser"));
				listClients.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listClients;
	}
	
}
