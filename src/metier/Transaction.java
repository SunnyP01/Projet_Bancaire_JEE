package metier;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Transaction {
	
	private ArrayList<Compte> comptes = new ArrayList<Compte>();
	
	public ArrayList<Compte> getComptes(){
		return comptes;
	}
	
	public void setComptes(ArrayList<Compte> comptes){
		this.comptes = comptes;
	}
	
	public void add(Compte c) throws SQLException{
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("INSERT INTO compte VALUE(NULL,?,?,?,?)");
			pr.setString(1, c.getNom());
			pr.setString(2, c.getDateOuverture());
			pr.setString(3, c.getSolde());
			pr.setInt(4, c.getIdClient());
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comptes.add(c);
	}
	
	public void remove(Long id) throws SQLException{
		/*for(Compte c : comptes){
			if(c.getId()==id){
				comptes.remove(c);
				break;
			}
		}
		System.out.println("id supp " + id);*/
		
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("DELETE FROM compte WHERE id = ?");
			pr.setLong(1, id);
			
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Compte> getAll() throws SQLException{
		ArrayList<Compte> listComptes = new ArrayList<Compte>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM compte WHERE idClient = 1");
			ResultSet rs = pr.executeQuery();
			pr.execute();
			
			while(rs.next()){
				Compte c = new Compte();
				c.setId(rs.getLong("id"));
				c.setDateOuverture(rs.getString("dateOuverture"));
				c.setNom(rs.getString("nom"));
				c.setSolde(rs.getString("solde"));
				c.setIdClient(rs.getInt("idClient"));
				listComptes.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listComptes;
	}

}
