package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

import metier.*;



public class CompteDAO {
	
	public void addCompte(Compte c) throws SQLException{
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("INSERT INTO compte VALUE(?,?,?,?,?)");
		    pr.setLong(1, c.getId());
			pr.setString(2, c.getNom());
			pr.setString(3, c.getDateOuverture());
			pr.setString(4, c.getSolde());
			pr.setInt(5, c.getIdClient());
			pr.execute();
			System.out.println("Insertion Réussi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//comptes.add(c);
	}
	
	public void deleteCompte(Long id) throws SQLException{
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
	
	public ArrayList<Compte> getAllComptes() throws SQLException{
		ArrayList<Compte> listComptes = new ArrayList<Compte>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM compte");
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
	
	public ArrayList<Compte> getAllComptesByUser(int idUser) throws SQLException{
		ArrayList<Compte> listComptes = new ArrayList<Compte>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * "
		    		+ "														FROM compte cpt, client cli"
		    		+ "														WHERE cpt.idClient = cli.id "
		    		+ "														AND cli.idUser = "+ idUser);
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
	
	public void depotSurCompte (int idCompteCred, int idCompteDeb, float montant)
	{
		int nbTransaction=0;
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("Update compte set solde = solde -"+montant+""
		    		+ "														Where id = "+idCompteDeb);
			pr.execute();
			System.out.println("Retrait sur le compte debiteur effectué");
			
			PreparedStatement pr2 = (PreparedStatement) con.prepareStatement("Update compte set solde = solde +"+montant+""
		    		+ "														Where id = "+idCompteCred);
			pr2.execute();
			System.out.println("Dépôt sur le compte crediteur effectué");
			
			
			pr2 = (PreparedStatement) con.prepareStatement("select count(*) nbTransaction from transaction");
			
			ResultSet rs = pr2.executeQuery();
			if (rs.next()) {
				nbTransaction = rs.getInt("nbTransaction");
				nbTransaction = nbTransaction +1;
			}
			System.out.println("IdCompteDeb : " + idCompteDeb + "Id Compte Cred : " + idCompteCred + "Id TRansaction : "+ nbTransaction + " Montant : "+ montant);
			PreparedStatement pr3 = (PreparedStatement) con.prepareStatement("INSERT INTO transaction VALUE(?,?,?,?,?)");
		    pr3.setInt(1, nbTransaction + 1);
			pr3.setInt(2, idCompteCred);
			pr3.setInt(3, idCompteDeb);
			pr3.setFloat(4, montant);
			pr3.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			pr3.execute();
			System.out.println("Ajout dans l'historique effectué");
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
