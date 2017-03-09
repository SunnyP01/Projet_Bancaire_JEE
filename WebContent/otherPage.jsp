<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Other page</title>
    </head>
    <body>
    <h1>Bancaire App</h1>
        <p>
            <% String login = (String) request.getParameter("login");
               String nom = (String) request.getParameter("nom");
               String password = (String) request.getParameter("mdp");
            
            if(login.equals("ludo") && password.equals("azerty")){
            	out.println("Bravo "+nom+" tu es maintenant connecté");
            }else{
            	out.println( "Mauvais identifiant(s)" );
            }
            
            
            %>
            
            <a href="pageComptes.jsp">Consulter mes comptes</a>
        </p>
    </body>
</html>