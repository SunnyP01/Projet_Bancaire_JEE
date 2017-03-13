<%@page import="java.net.URL"%>
<%@page import="com.mysql.fabric.Response"%>
<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8" />
<title>Page Client</title>
</head>
<body>
		<%
		CompteBeans comptes;
		if (request.getAttribute("modele") != null) {
			comptes = (CompteBeans) request.getAttribute("modele");
		} else {
			int idConseiller = 0;
			Conseiller leConseiller = new Conseiller();
			ConseillerDAO monConseillerDAO = new ConseillerDAO();
			
			comptes = new CompteBeans();
			CompteDAO mesComptes = new CompteDAO();
			
			ClientDAO monClient = new ClientDAO();
			
			comptes.setListe(mesComptes.getAllComptesByUser((int)request.getAttribute("idUser")));
			
			idConseiller = monClient.getIdConseillerByUser((int)request.getAttribute("idUser"));
			System.out.println("id User : "+(int)request.getAttribute("idUser"));
			System.out.println("id Conseiller : "+idConseiller);
			leConseiller = monConseillerDAO.getConseillerById(idConseiller);
	%>

	<h1>Bienvenue ${prenom} ${nom} </h1>
	<h3>Pour toute demande vous pouvez contacter votre conseiller : <%=leConseiller.getPrenom()%> <%=leConseiller.getNom()%> <% } %> </h3>
	<h2>Mes Comptes :</h2>

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
	
	<h2> Faire un virement </h2>
	<form action="Virement" method="post">
	<table border = "1" width="50%">
			<tr>
				<td> Du compte </td>
				<td>
						<select id="idCompteCred" name="idCompteCred">
			<%

				CompteBeans comptes2 = new CompteBeans();
				CompteDAO mesComptes = new CompteDAO();
				comptes2.setListe(mesComptes.getAllComptesByUser((int)request.getAttribute("idUser")));
				Iterator<Compte> list3 = comptes2.getListe().iterator();
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
				Iterator<Compte> list2 = comptes2.getListe().iterator();
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
				<td> <input type="text" id="montant" name="montant" required/></td>
			</tr>
		
			<tr> 
				<td>	<input type="submit" value="Virement"> </td> 
			</tr>
	</table>
	</form>
	
	<h2> Consulter l'historique de mes comptes </h2>
	<form action="pageHistorique.jsp" method="post">
	<table border = "1" width="50%">
			<tr>
				<td> Selectionner le compte </td>
				<td>
						<select id="idCompte" name="idCompte">
			<%

				comptes = new CompteBeans();
				mesComptes = new CompteDAO();
				comptes.setListe(mesComptes.getAllComptesByUser((int)request.getAttribute("idUser")));
				list = comptes.getListe().iterator();
				while(list.hasNext()){
					Compte c = list.next();
			%>
				<option value=<%=c.getId()%>> <%=c.getNom() %> </option>
			<%
				}
			%>
			</select>
				
				</td>
			</tr>
				<tr> 
				<td>	<input type="submit" value="Consulter"> </td> 
			</tr>
	</table>
	</form>
	
		
</body>
</html>