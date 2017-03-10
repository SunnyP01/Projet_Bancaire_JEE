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
<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
<%
	CompteBeans comptes;
	if(request.getAttribute("modele") != null){
		comptes = (CompteBeans)request.getAttribute("modele");
	}else{
		CompteDAO o = new CompteDAO();
		comptes = new CompteBeans();
		comptes.setListe(o.getAllComptes());
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