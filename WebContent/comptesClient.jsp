<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mes comptes</title>
</head>
<body>

<%
	CompteBeans comptes;
	if(request.getAttribute("modele") != null){
		comptes = (CompteBeans)request.getAttribute("modele");
	}else{
		CompteDAO mesComptes = new CompteDAO();
		comptes = new CompteBeans();
		comptes.setListe(mesComptes.getAllComptes());
	}

%>

<h1>Mes comptes</h1>

<table border="1", width="60%">
	<tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Date Ouverture</th>
		<th>Solde</th>
		<th>id Client</th>
		<th>Option</th>
	</tr>
	<%
		Iterator<Compte> list = comptes.getListe().iterator();
		while(list.hasNext()){
			Compte c = list.next();
	%>
	
	<tr>
		<td><%=c.getId() %> </td>
		<td><%=c.getNom() %> </td>
		<td><%= c.getDateOuverture() %></td>
		<td><%= c.getSolde() %> euros</td> 
		<td><%= c.getIdClient() %></td>
		<td><form action="prodserv" method="post">
				<input type="hidden" name="id" value="<%= c.getId() %>">
				<input type="hidden" name="action" value="supprimer">
				<input type="submit" value="supprimer">
			</form></td>
	</tr>
	
	<%
		}
	%>
	<tr>
		
	</tr>
</table>



</body>
</html>