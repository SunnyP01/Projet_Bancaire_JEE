package com.projetBancaireJEE;
import java.sql.*;

public class Connexion {
	ResultSet re;  
	public Connection getConnexion() {      
		Connection conn = null;
		try {
	      Class.forName("com.mysql.jdbc.Driver");
		  String url = "jdbc:mysql://localhost:3306/bancaireApp";
	      String user = "root";
	      String passwd = "root";
	      conn = DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion effective");
	    } catch (Exception e) {
	    
	      e.printStackTrace();
	    } finally {
	        if ( conn  == null )
	            try {
	                /* Fermeture de la connexion */
	            	conn.close();
	            	System.out.println("Connexion close");
	            } catch ( SQLException ignore ) {
	                /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
	            }
	    }
	    return conn;
	  }
	
}
