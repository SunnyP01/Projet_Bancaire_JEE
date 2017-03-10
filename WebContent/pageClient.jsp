<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8" />
<title>Page Client</title>
</head>
<body>
	<h1>Bienvenue ${prenom} ${nom}</h1>

	<h2>Mes Comptes :</h2>
	<%
		CompteBeans comptes;
		if (request.getAttribute("modele") != null) {
			comptes = (CompteBeans) request.getAttribute("modele");
		} else {
			CompteDAO mesComptes = new CompteDAO();
			comptes = new CompteBeans();
			comptes.setListe(mesComptes.getAllComptesByUser((int)request.getAttribute("idUser")));
		}
	%>

	<table border="1" , width="60%">
		<tr>
			<th>Nom</th>
			<th>Date Ouverture</th>
			<th>Solde</th>
		</tr>
		<%
			Iterator<Compte> list = comptes.getListe().iterator();
			while (list.hasNext()) {
				Compte c = list.next();
		%>

		<tr>
			<td><%=c.getNom()%></td>
			<td><%=c.getDateOuverture()%></td>
			<td><%=c.getSolde()%> euros</td>
		</tr>

		<%
			}
		%>
		<tr>

		</tr>
	</table>
	<h2> </h2>

</body>
</html>