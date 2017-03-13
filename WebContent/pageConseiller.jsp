<%@page import="ClassDAO.*"%>
<%@page import="metier.*"%>
<%@page import="servletClass.*"%>
<%@page import="com.projetBancaireJEE.*"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Conseiller page</title>
    </head>
    <body>
	    <h1>Page Conseiller</h1>
	    
	    <h3>Voici la liste de vos clients</h1>
	
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
			clients.setListe(o2.getAllClientByConseiller(2));
			
			
		}
	   
	    
	    %>
	   
	    <form action="AffectationClient" method="post">
<table border = "1" width="50%">
	
		<tr>
			<td> Client </td>
			<td>
			
					<select id="idClient" name="idClient">
		<%
			Iterator<Client> list2 = clients.getListe().iterator();
			while(list2.hasNext()){
				Client c = list2.next();
		%>
			<option value = <%= c.getId() %>> <%=c.getPrenom() + " " + c.getNom() %> </option>
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