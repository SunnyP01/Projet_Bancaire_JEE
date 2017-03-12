package ClassDAO;

import metier.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

public class ConseillerDAO {
	
	public Conseiller getConseillerById (int idConseiller)
	{
		Conseiller conseiller = new Conseiller();
		try { 
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("Select * from conseiller, user"
		    															  + " WHERE conseiller.idUser = user.id"
		    															  + " AND conseiller.id = "+idConseiller);
		    ResultSet rs = pr.executeQuery();
		    if (rs.next()) {
		    	conseiller.setEmail(rs.getString("email"));
		    	conseiller.setNom(rs.getString("nom"));
		    	conseiller.setPrenom(rs.getString("prenom"));
		    	conseiller.setPassword(rs.getString("password"));
		    	//conseiller.setClient(null);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conseiller;
	}
}
