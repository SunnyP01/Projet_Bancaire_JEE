<%@page import="com.projetBancaireJEE.*" %>
<%@page import="metier.Transaction"%>
<%@page import="metier.Compte"%>
<%@page import="java.util.Iterator"%>
<%@page import="servletClass.CompteBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mes comptes</title>
</head>
<body>
<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
<%
	CompteBeans comptes;
	if(request.getAttribute("modele") != null){
		comptes = (CompteBeans)request.getAttribute("modele");
	}else{
		Transaction o = new Transaction();
		comptes = new CompteBeans();
		comptes.setListe(o.getAll());
	}

%>

<h1>Faire un virement</h1>

<form action="virement.jsp" method="post">
<table border = "1" width="50%">
	<tr>
			<td> Du compte </td>
			<td><select name="compteDebit">
		<%
			Iterator<Compte> list = comptes.getListe().iterator();
			while(list.hasNext()){
				Compte c = list.next();
		%>
		
			<option > <%=c.getNom() %> </option>
		
		<%
			}
		%>
		</select>
			</td>
		</tr>
		<tr>
			<td> jusqu'au compte </td>
			<td>
			
					<select name="compteCredit">
		<%
			Iterator<Compte> list2 = comptes.getListe().iterator();
			while(list2.hasNext()){
				Compte c = list2.next();
		%>
			<option > <%=c.getNom() %> </option>
		<%
			}
		%>
		</select>
			
			</td>
		</tr>
		<tr>
			<td> Montant (en euros) </td>
			<td> <input type="text" name="montantVirement"/></td>
		</tr>
	
		<tr> 
			<td><input type="submit" value="valider"></td> 
		</tr>
</table>
</form>

<%
	//String compteDebit=request.getParameter("compteDebit"); 
	//String compteCredit=request.getParameter("compteCredit");
	//int solde = Integer.parseInt(request.getParameter("solde"));
	

	//java.sql.Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BancaireApp","root","root");
	
	 // create the java mysql update preparedstatement
    //String query = "UPDATE from compte set solde = solde +200 WHERE id=14";
    //PreparedStatement preparedStmt = cn.prepareStatement(query);

    // execute the java preparedstatement
    //preparedStmt.executeUpdate();
    
    
 // create the java mysql update preparedstatement
    //String query2 = "UPDATE from compte set solde = solde -200 WHERE id=15";
//    PreparedStatement preparedStmt2 = cn.prepareStatement(query2);

    // execute the java preparedstatement
  //  preparedStmt2.executeUpdate();
%>

</body>
</html>