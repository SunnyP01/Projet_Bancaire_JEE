package com.projetBancaireJEE;
import java.sql.*;

public class Connexion {
	ResultSet re;  
	public Connection getConnexion() {      
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
		  String url = "jdbc:mysql://localhost:3306/bancaireApp";
	      String user = "root";
	      String passwd = "sesrouut";
	      Connection conn = DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion effective !");
	      return conn;
	    } catch (Exception e) {
	    
	      e.printStackTrace();
	    } 
	    return null;
	  }
	
	public void fermer(){
	     try {
	    	 re.close();
	     } catch (SQLException e) {
	    	 System.out.println("Problème de fermeture de la Base de données");
	     }
	     System.out.println("Base de données Fermée");
	} 
	
}
