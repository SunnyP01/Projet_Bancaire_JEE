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

import ClassDAO.ClientDAO;
import metier.Compte;
import metier.Transaction;

public class ConseillerServlet extends HttpServlet {
	ClientBeans cb;
	/*
	private Operation op;
	
	
	@Override
	public void init() throws ServletException {
		op = new Operation();
	}
	*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClientDAO cd = new ClientDAO();
		if(req.getParameter("action") != null){
			try {
				int client = Integer.parseInt(req.getParameter("client"));
				int conseiller = Integer.parseInt(req.getParameter("conseiller"));
//				cd.addConseiller(1,1);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		cb = new ClientBeans();
		
		req.setAttribute("modele", cb);
		req.getRequestDispatcher("affectationClientAdmin.jsp").forward(req, resp);
	}

}
