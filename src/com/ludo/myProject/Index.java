package com.ludo.myProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String message = "Transmission de variables : OK !";
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		this.getServletContext().getRequestDispatcher( "otherPage.html" ).forward( request, response );
		System.out.println(message);
		this.getServletContext().getRequestDispatcher("/otherPage.jsp")
		.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("nom",nom);
		session.setAttribute("login",login);
		session.setAttribute("mdp",mdp);
		
		response.sendRedirect("/Login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
