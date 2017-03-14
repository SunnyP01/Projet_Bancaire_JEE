package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

import metier.*;

public class TransactionDAO {

	public ArrayList<Transaction> getTransactionByCompte(int idCompte) {
		ArrayList<Transaction> mesTransactions = new ArrayList<Transaction>();
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
			Statement sta = con.createStatement();
			PreparedStatement pr = (PreparedStatement) con.prepareStatement("Select tr.*," + "cred.id idCred,"
					+ "cred.nom nomCred," + "cred.dateOuverture dateCred," + "cred.solde soldeCred,"
					+ "cred.idClient idClientCred," + "deb.id idDeb," + "deb.nom nomDeb," + "deb.dateOuverture dateDeb,"
					+ "deb.solde soldeDeb," + "deb.idClient idClientDeb"
					+ " from transaction tr, compte cred, compte deb " + " where tr.idCrediteur = cred.id "
					+ " and tr.idDebiteur = deb.id " + " AND (idCrediteur =" + idCompte + " or idDebiteur =" + idCompte
					+ ") " + " ORDER by tr.id desc");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Compte compteCred = new Compte();
				Compte compteDeb = new Compte();
				compteCred.setId(rs.getLong("idCred"));
				compteCred.setDateOuverture(rs.getString("dateCred"));
				compteCred.setNom(rs.getString("nomCred"));
				compteCred.setSolde(rs.getString("soldeCred"));
				compteCred.setIdClient(rs.getInt("idClientCred"));
				compteDeb.setId(rs.getLong("idDeb"));
				compteDeb.setDateOuverture(rs.getString("dateDeb"));
				compteDeb.setNom(rs.getString("nomDeb"));
				compteDeb.setSolde(rs.getString("soldeDeb"));
				compteDeb.setIdClient(rs.getInt("idClientDeb"));
				Transaction tr = new Transaction();
				tr.setId(rs.getInt("id"));
				tr.setCompteCred(compteCred);
				tr.setCompteDeb(compteDeb);
				tr.setMontant(rs.getFloat("montant"));
				tr.setDate(rs.getDate("date"));
				mesTransactions.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mesTransactions;

	}
}
