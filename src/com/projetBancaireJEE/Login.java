package com.projetBancaireJEE;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import metier.Compte;
import metier.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";   
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		ConnexionForm form = new ConnexionForm();

	    User utilisateur = form.connecterUtilisateur( request );
		
	    String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		HttpSession session = request.getSession();
		
		session.setAttribute(ATT_SESSION_USER,nom);
		
		/* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, login );
        request.setAttribute( ATT_USER, nom );

        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        /*if(login.equals("ludo") && mdp.equals("azerty")){
			response.sendRedirect("dashboard");
		}else{
			response.sendRedirect("login");
		}
		*/
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM utilisateur WHERE email = '" + login + "' AND password = '" + mdp +"'");
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("pageVerification.jsp" ).forward( request, response );
		
	}
	
	public void toLogIn(User myUser) throws SQLException{
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM user");
			ResultSet rs = pr.executeQuery();
			pr.execute();
			while(rs.next()){
				Compte c = new Compte();
				c.setId(rs.getLong("id"));
				c.setDateOuverture(rs.getString("dateOuverture"));
				c.setNom(rs.getString("nom"));
				c.setIdClient(rs.getInt("idUser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
