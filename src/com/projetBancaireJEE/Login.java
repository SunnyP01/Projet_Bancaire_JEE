package com.projetBancaireJEE;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		HttpSession session = request.getSession();
		session.setAttribute("nom",nom);
		session.setAttribute("login",login);
		session.setAttribute("mdp",mdp);
		
		/*if(login.equals("ludo") && mdp.equals("azerty")){
			response.sendRedirect("dashboard");
		}else{
			response.sendRedirect("login");
		}
		*/
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM utilisateur WHERE email = '" + login + "' AND password = '" + mdp +"'");
			ResultSet rs = pr.executeQuery();
			pr.execute();
			maConnexion.fermer();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void toLogIn(User myUser) throws SQLException{
		try {
			Connexion maConnexion = new Connexion();
			Connection con = maConnexion.getConnexion();
		    Statement sta = con.createStatement();
		    PreparedStatement pr = (PreparedStatement) con.prepareStatement("SELECT * FROM user");
			ResultSet rs = pr.executeQuery();
			pr.execute();
			maConnexion.fermer();
			
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
