<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@page import="java.util.Iterator"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Mes comptes</title>
	</head>
	<body>


<h2> Faire un virement </h2>
	<form action="Virement" method="post">
	<table border = "1" width="50%">
			<tr>
				<td> Du compte </td>
				<td>
						<select id="idCompteCred" name="idCompteCred">
			<%

				CompteBeans comptes = new CompteBeans();
				CompteDAO mesComptes = new CompteDAO();
				comptes.setListe(mesComptes.getAllComptesByUser((int)request.getAttribute("idUser")));
				Iterator<Compte> list3 = comptes.getListe().iterator();
				while(list3.hasNext()){
					Compte c = list3.next();
			%>
				<option value=<%=c.getId()%>> <%=c.getNom() %> </option>
			<%
				}
			%>
			</select>
				
				</td>
			</tr>
			<tr>
				<td> Vers le compte </td>
				<td>
				
						<select id="idCompteDeb" name="idCompteDeb">
			<%
				Iterator<Compte> list2 = comptes.getListe().iterator();
				while(list2.hasNext()){
					Compte c = list2.next();
			%>
				<option value=<%=c.getId()%>> <%=c.getNom() %> </option>
			<%
				}
			%>
			</select>
				
				</td>
			</tr>
			<tr>
				<td> Montant (en euros) </td>
				<td> <input type="text" id="montant" name="montant"/></td>
			</tr>
		
			<tr> 
				<td>	<input type="submit" value="virement"> </td> 
			</tr>
	</table>
	</form>

</body>
</html>