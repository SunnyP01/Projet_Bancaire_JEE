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
<title>Conseiller page</title>
<link rel="stylesheet" href="./css/style.css" type="text/css" />
</head>
<body>

	<div id="page">
		<div id="logo">
			<h1>Page Conseiller</h1>
		</div>
		<div id="nav">
			<ul>
				<li><a href="pageConseiller.jsp">Acceuil Conseiller</a></li>
				<li><a href="./">Déconnexion</a></li>
			</ul>
		</div>
		<div id="content">
			<%
				ConseillerBeans conseillers;
				ClientBeans clients;
				if (request.getAttribute("modele") != null) {
					conseillers = (ConseillerBeans) request.getAttribute("modele");
					clients = (ClientBeans) request.getAttribute("modele");
				} else {
					ConseillerDAO o = new ConseillerDAO();
					conseillers = new ConseillerBeans();
					conseillers.setListe(o.getAllConseillers());

					ClientDAO o2 = new ClientDAO();
					clients = new ClientBeans();
					clients.setListe(o2.getAllClientByConseiller((int) request.getAttribute("idUser")));

				}
			%>

			<h2>Vous pouvez consulter les comptes de vos clients</h2>

			<form action="AffectationClient" method="post">
				<table border="1" width="50%">

					<tr>
						<td>Client</td>
						<td><select id="idClient" name="idClient">
								<%
									Iterator<Client> list2 = clients.getListe().iterator();
									while (list2.hasNext()) {
										Client c = list2.next();
								%>
								<option value=<%=c.getId()%>>
									<%=c.getPrenom() + " " + c.getNom()%>
								</option>
								<%
									}
								%>
						</select></td>
					</tr>

					<tr>
						<td><input type="submit" name="action" value="valider"></td>
					</tr>
				</table>
			</form>
			<h2>Gestion des comptes clients :</h2>
			<%
				CompteBeans comptes;
				if (request.getAttribute("modele") != null) {
					comptes = (CompteBeans) request.getAttribute("modele");
				} else {
					CompteDAO mesComptes = new CompteDAO();
					comptes = new CompteBeans();
					comptes.setListe(mesComptes.getAllComptes());
				}
			%>

			<h3>Modifier Mail Client</h3>
			<form action="ClientServlet" method="post">
				<table border="1" , width="60%">
					<tr>
						<th>Client</th>
						<th>Nouveau Mail</th>
					</tr>
					<tr>
						<td><select id="idClient" name="idClient">
								<%
									Iterator<Client> maListe = clients.getListe().iterator();
									while (maListe.hasNext()) {
										Client c = maListe.next();
								%>
								<option value=<%=c.getId()%>>
									<%=c.getPrenom() + " " + c.getNom()%>
								</option>
								<%
									}
								%>
						</select></td>
						<td><input type="text" id="email" name="email"
							placeholder="Nouveau Mail" required /></td>
						<td><input type="submit" id="valider" value="Valider" /></td>
					</tr>
				</table>
			</form>

			<h3>Modifier Mot de passe Client</h3>
			<form action="ClientServlet" method="post">
				<table border="1" , width="60%">
					<tr>
						<th>Client</th>
						<th>Nouveau Mot de Passe</th>
					</tr>
					<tr>
						<td><select id="idClient" name="idClient">
								<%
									Iterator<Client> maListe2 = clients.getListe().iterator();
									while (maListe2.hasNext()) {
										Client c = maListe2.next();
								%>
								<option value=<%=c.getId()%>>
									<%=c.getPrenom() + " " + c.getNom()%>
								</option>
								<%
									}
								%>
						</select></td>
						<td><input type="password" id="newPasswd" name="newPasswd"
							placeholder="Nouveau Mot de passe" required /></td>

						<td><input type="submit" id="valider" value="Valider" /></td>
					</tr>
				</table>
			</form>
			
			
		</div>
		<div id="footer">
			<p>
				Website developed by Sunny PURSEED & Ludovic TRAPEAU</a>
			</p>
		</div>
	</div>






</body>
</html>