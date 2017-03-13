package servletClass;

import java.*;
import java.io.IOException;
import java.sql.*;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.projetBancaireJEE.Connexion;
import ClassDAO.*;
import metier.*;
import javax.servlet.annotation.WebServlet;
import java.net.URL;
import com.mysql.fabric.Response;
import com.projetBancaireJEE.*;
import javax.sql.*;
import java.util.Iterator;
import java.io.*;




public class AffectationClient extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    ClientDAO monClient = new ClientDAO();
		String idConseiller = req.getParameter("idConseiller");
		String idClient = req.getParameter("idClient");
		
		System.out.println("On a " + idClient + " et " + idConseiller);
		
        try {
        	
        	
    	    monClient.addConseiller(Integer.parseInt(idClient), Integer.parseInt(idConseiller));
            
        	
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        	
        }
        
   		//req.getRequestDispatcher("affectationClientAdmin.jsp").forward(req, resp);
	}
}