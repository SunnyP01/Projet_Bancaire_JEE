package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import metier.*;
import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;
	

public class ClientDAO {

	public int getIdConseillerByUser(int idUser)
	{
		int idConseiller =0;
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("Select idConseiller from client where idUser = "+idUser);
		    ResultSet rs = pr.executeQuery();
		    if (rs.next()) {
		    	idConseiller = rs.getInt("idConseiller");
		    	System.out.println("Id Conseiller récupéré");
		    }
		    else 
		    	System.out.println("Le client n'a pas de conseiller");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idConseiller;
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
