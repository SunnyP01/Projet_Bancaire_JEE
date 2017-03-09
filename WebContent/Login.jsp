<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>atozknowledge.com demo loginjsp</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
	<%@ page import="metier.Connexion"%>
	<%
String email=request.getParameter("email"); 
session.putValue("userid",email); 
String pwd=request.getParameter("pwd"); 

Connexion maConnexion = new Connexion();
Connection con = maConnexion.getConnexion();
Statement sta = con.createStatement();
ResultSet rs=sta.executeQuery("select * from user where email='"+email+"'" + "AND password = '" +pwd+ "'"); 

if(rs.next()) 
{ 
	if(rs.getString(2).equals(pwd)) 
	{ 
		out.println("welcome"+email); 
	} 
	else 
	{ 
		
		%><p><a href="comptesClient.jsp">Consulter mes comptes</a></p>
		  <p><a href="pageComptes.jsp">Créer des comptes</a></p>
		  <p><a href="virement.jsp">Effectuer un virement</a></p><%
	} 
} 
else 
	out.println("Email ou mot de passe incorrect"); 
%>

</body>
</html>