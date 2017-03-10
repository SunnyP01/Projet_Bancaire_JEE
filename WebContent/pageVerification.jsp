<%@page import="com.mysql.fabric.Response"%>
<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loginjsp</title>
</head>
<body>
	<%
		String email=request.getParameter("email"); 
		session.putValue("userid",email); 
		String pwd=request.getParameter("pwd");		
		Connexion maConnexion = new Connexion();
		Connection con = maConnexion.getConnexion();
		Statement sta = con.createStatement();
		ResultSet rs=sta.executeQuery("select id from user where email='"+email+"'" + "AND password = '" +pwd+ "'"); 
		int idUser=0;
		if(rs.next()) 
		{
			idUser = rs.getInt("id");
			ResultSet rs2=sta.executeQuery("select id from client where idUser="+ idUser); 
			if (rs2.next())
			{
				response.sendRedirect("pageClient.jsp");
			}
			
			ResultSet rs3=sta.executeQuery("select id from administrateur where idUser="+ idUser); 
			if (rs3.next())
			{
				response.sendRedirect("pageAdministrateur.jsp");
			}
			
			ResultSet rs4=sta.executeQuery("select id from conseiller where idUser="+ idUser); 
			if (rs4.next())
			{
				response.sendRedirect("pageConseiller.jsp");
			}
		}  
		else 
			out.println("Email ou mot de passe incorrect");
		
		
		
			
		
		
		
		%>
</body>
</html>