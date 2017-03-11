<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'affectation d'un conseiller à un client</title>
</head>
<body>

	<h1>Page d'affectation d'un conseiller à un client</h1>
	
	  <%
	  
	  ConseillerBeans conseillers;
	  ClientBeans clients;
		if(request.getAttribute("modele") != null){
			conseillers = (ConseillerBeans)request.getAttribute("modele");
			clients = (ClientBeans)request.getAttribute("modele");
		}else{
			ConseillerDAO o = new ConseillerDAO();
			conseillers = new ConseillerBeans();
			conseillers.setListe(o.getAllConseillers());
			
			ClientDAO o2 = new ClientDAO();
			clients = new ClientBeans();
			clients.setListe(o2.getAllClient());
		}
	    
	    //ClientDAO monClient = new ClientDAO();
	    //monClient.addConseiller(1, 1);
	   
	    
	    %>
	    
	    <form action="prodServ2" method="post">
<table border = "1" width="50%">
	<tr>
			<td> Conseiller </td>
			<td><select name="conseiller" value = 1>
		<%
			Iterator<Conseiller> list = conseillers.getListe().iterator();
			while(list.hasNext()){
				Conseiller c = list.next();
		%>
		
			<option > <%= c.getPrenom() + " " + c.getNom() %> </option>
		
		<%
			}
		%>
		</select>
			</td>
		</tr>
		<tr>
			<td> Client </td>
			<td>
			
					<select name="client" value=1>
		<%
			Iterator<Client> list2 = clients.getListe().iterator();
			while(list2.hasNext()){
				Client c = list2.next();
		%>
			<option > <%=c.getPrenom() + " " + c.getNom() %> </option>
		<%
			}
		%>
		</select>
			
			</td>
		</tr>
	
		<tr> 
			<td><input type="submit" name="action" value="valider"></td> 
		</tr>
</table>
</form>

</body>
</html>