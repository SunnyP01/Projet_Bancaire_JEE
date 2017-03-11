package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

import metier.Compte;
import metier.Conseiller;

public class ConseillerDAO {
	
	public ArrayList<Conseiller> getAllConseillers() throws SQLException{
		ArrayList<Conseiller> listConseillers = new ArrayList<Conseiller>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM conseiller c, user u "
		    																+ "WHERE c.idUser = u.id");
			ResultSet rs = pr.executeQuery();
			pr.execute();
			
			while(rs.next()){
				Conseiller c = new Conseiller(rs.getString("email"),rs.getString("nom"),rs.getString("prenom"),rs.getString("password"));
				//c.setId(rs.getLong("id"));
				//c.setId(rs.getInt("idUser"));
				listConseillers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listConseillers;
	}

}
