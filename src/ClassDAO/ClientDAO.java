package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
}
