package servletClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ClassDAO.UserDAO;
import sun.invoke.empty.Empty;


public class ClientServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 	String oldPasswd = req.getParameter("oldPasswd");
			String newPasswd = req.getParameter("newPasswd");
			String email = req.getParameter("email");
			String idUser = req.getParameter("idUser");
			String idClient = req.getParameter("idClient");
			String url = req.getRequestURL().toString();
			System.out.println("E mail : "+req.getParameter("email"));
			
			
			if (idClient != null && email!=null)
			{
				try {
				UserDAO nvxClient = new UserDAO();
				nvxClient.updateEmailClient(Integer.parseInt(req.getParameter("idClient")), email);
				System.out.println("Votre nouveau mail est : "+req.getParameter("email"));
				req.getRequestDispatcher(url).forward(req, resp);
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
			if (email != null && idUser!=null){
				try {
				UserDAO nvxUser = new UserDAO();
				nvxUser.updateEmailUser(Integer.parseInt(req.getParameter("idUser")), email);
				System.out.println("Votre nouveau mail est : "+req.getParameter("email"));
				req.getRequestDispatcher("pageValidation.jsp").forward(req, resp);
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if (oldPasswd!=null && newPasswd!=null)
			{
				try {
				UserDAO nvxUser = new UserDAO();
				nvxUser.updateMDPUser(Integer.parseInt(req.getParameter("idUser")), oldPasswd, newPasswd);
				req.getRequestDispatcher("pageValidation.jsp").forward(req, resp);
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if (newPasswd != null && idClient!=null)
			{
				try {
					UserDAO nvxUser = new UserDAO();
					nvxUser.updateMDPClient(Integer.parseInt(req.getParameter("idClient")), newPasswd);
					req.getRequestDispatcher(url).forward(req, resp);
					}
					catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
	}
}
