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




public class Virement extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompteDAO compteDAO = new CompteDAO();
		String idCompteDeb = req.getParameter("idCompteDeb");
		String idCompteCred = req.getParameter("idCompteCred");
        String montant = req.getParameter("montant");
        String idUser = req.getParameter("idUser");
		
        try {
        	//Vérification des infos récupérées 
			//System.out.println(idCompteDeb);
        	//System.out.println(idCompteCred);
        	//System.out.println(montant);
        	
        	compteDAO.depotSurCompte(Integer.parseInt(idCompteDeb), Integer.parseInt(idCompteCred), Float.parseFloat(montant));
            
        	
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        	
        }
        
   		req.getRequestDispatcher("pageValidation.jsp").forward(req, resp);
	}
}