package servletClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.management.openmbean.OpenDataException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassDAO.CompteDAO;
import metier.Compte;
import metier.Transaction;

public class CompteServlet extends HttpServlet {
	CompteBeans cb;
	/*
	private Operation op;
	
	
	@Override
	public void init() throws ServletException {
		op = new Operation();
	}
	*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompteDAO op = new CompteDAO();
		if(req.getParameter("action") != null){
			try {
				op.deleteCompte(Long.parseLong(req.getParameter("id")));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			//Récup des infos
			String nom = req.getParameter("nom");
			String dateOuverture = req.getParameter("dateOuverture");
			String solde = req.getParameter("solde");
			String idUser = req.getParameter("idUser");
			
			// Creation des objets
			Compte c = new Compte(1L,nom, dateOuverture,solde,Integer.parseInt(idUser));
			
			
			//Traitement
			try {
				op.addCompte(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Afficher infos
			/*PrintWriter pr = resp.getWriter();
			pr.println(nom);*/
		}
		cb = new CompteBeans();
		try {
			cb.setListe(op.getAllComptes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("modele", cb);
		req.getRequestDispatcher("pageComptes.jsp").forward(req, resp);
	}

}
