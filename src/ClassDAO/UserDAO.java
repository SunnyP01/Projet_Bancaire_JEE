package ClassDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

import metier.User;

public class UserDAO {

	public void updateEmailUser(int idUser, String email) throws SQLException{
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("Update user set email = '"+email+"' where id ="+idUser);
		    pr.execute();
		    JOptionPane.showMessageDialog(null, "Votre E-Mail a bien été mis à jour", "Succès : Mise à Jour", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void updateEmailClient(int idClient, String email) throws SQLException{
		int idUser;
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("Select idUser from client where id = "+idClient);
		    ResultSet rs = pr.executeQuery();
		    if (rs.next())
		    {	
		    	idUser=rs.getInt("idUser");
		    	pr = (PreparedStatement) con.prepareStatement("Update user set email = '"+email+"' where id ="+idUser);
		    	pr.execute();
		    	JOptionPane.showMessageDialog(null, "Votre E-Mail a bien été mis à jour", "Succès : Mise à Jour", JOptionPane.INFORMATION_MESSAGE);
		    }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public void updateMDPUser(int idUser, String oldPasswd, String newPasswd) throws SQLException{
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("select password from user where id ="+idUser);
		    ResultSet rs = pr.executeQuery();
		    if (rs.next())
		    {
		    	if (oldPasswd.equals(rs.getString("password")))
		    	{
		    		pr = (PreparedStatement) con.prepareStatement("Update user set password = '"+newPasswd+"' where id ="+idUser);
				    pr.execute();
				    JOptionPane.showMessageDialog(null, "Votre Mot de passe a bien été mis à jour", "Succès : Mise à Jour", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	else 
		    		JOptionPane.showMessageDialog(null, "Votre ancien mot de passse est incorrect !", "Attention : Erreur !", JOptionPane.INFORMATION_MESSAGE);
		    }
		 	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void updateMDPClient(int idClient, String newPasswd) throws SQLException{
		int idUser;
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("Select idUser from client where id = "+idClient);
		    ResultSet rs = pr.executeQuery();
		    if (rs.next())
		    {	
		    	idUser=rs.getInt("idUser");
			    pr = (PreparedStatement) con.prepareStatement("Update user set password = '"+newPasswd+"' where id ="+idUser);
				pr.execute();
				JOptionPane.showMessageDialog(null, "Votre Mot de passe a bien été mis à jour", "Succès : Mise à Jour", JOptionPane.INFORMATION_MESSAGE);
		    }
		    else {
		    	JOptionPane.showMessageDialog(null, "Votre ancien mot de passse est incorrect !", "Attention : Erreur !", JOptionPane.INFORMATION_MESSAGE);
		    }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}