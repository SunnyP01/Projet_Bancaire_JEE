<%@page import="java.util.ArrayList"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Historique de compte</title>
</head>
<body>
	

	<%  int idCompte;
		ArrayList<Transaction> mesTransactions = new ArrayList<Transaction>(); 
		TransactionDAO transactionDAO = new TransactionDAO();
		idCompte = Integer.parseInt(request.getParameter("idCompte"));
		mesTransactions = transactionDAO.getTransactionByCompte(idCompte);
		System.out.println("id du compte selectionner dans form : "+idCompte);
	%>
	<h1>Historique du compte </h1>
	
	<table border="1" , width="60%">
		<tr>
			<th>idTransaction</th>
			<th>Nom du compte créditeur</th>
			<th>Nom du compte débiteur</th>
			<th>Montant de la transaction</th>
			<th>Date de la transaction</th>
		</tr>
		<%
			Iterator<Transaction> list = mesTransactions.iterator();
			while (list.hasNext()) {
				Transaction tr = list.next();
		%>

		<tr>
			<td><%=tr.getId()%></td>
			<td><%=tr.getCompteCred().getNom()%></td>
			<td><%=tr.getCompteDeb().getNom()%></td>
			<td><%=tr.getMontant()%> euros</td>
			<td><%=tr.getDate()%></td>
		</tr>

		<%
			}
		%>
		<tr>

		</tr>
	</table>
	
	
</body>
</html>