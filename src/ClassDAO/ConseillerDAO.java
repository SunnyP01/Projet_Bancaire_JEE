package ClassDAO;

import metier.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

import metier.Compte;
import metier.Conseiller;

public class ConseillerDAO {

	public ArrayList<Conseiller> getAllConseillers() throws SQLException {
		ArrayList<Conseiller> listConseillers = new ArrayList<Conseiller>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
			Statement sta = con.createStatement();
			PreparedStatement pr = (PreparedStatement) con
					.prepareStatement("SELECT * FROM conseiller c, user u " + "WHERE c.idUser = u.id");
			ResultSet rs = pr.executeQuery();
			pr.execute();

			while (rs.next()) {
				Conseiller c = new Conseiller(rs.getInt("id"), rs.getString("email"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("password"), null);
				// c.setId(rs.getLong("id"));
				// c.setId(rs.getInt("idUser"));
				listConseillers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listConseillers;
	}

	public Conseiller getConseillerById(int idConseiller) {
		Conseiller conseiller = new Conseiller();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
			Statement sta = con.createStatement();
			PreparedStatement pr = (PreparedStatement) con.prepareStatement("Select * from conseiller, user"
					+ " WHERE conseiller.idUser = user.id" + " AND conseiller.id = " + idConseiller);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				conseiller.setEmail(rs.getString("email"));
				conseiller.setNom(rs.getString("nom"));
				conseiller.setPrenom(rs.getString("prenom"));
				conseiller.setPassword(rs.getString("password"));
				// conseiller.setClient(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conseiller;
	}
}
