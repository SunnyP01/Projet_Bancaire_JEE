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
<title>Connexion</title>
</head>
<body>
<form action="pageVerification.jsp" method="post">

User name :<input type="text" name="email"/>
password :<input type="password" name="pwd" />
<input type="submit" value = "Se connecter"/>

</form>
</body>
</html>