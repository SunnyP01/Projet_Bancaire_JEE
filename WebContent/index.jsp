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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		var textfield = $("input[name=user]");
		$('button[type="submit"]')
				.click(
						function(e) {
							e.preventDefault();
							//little validation just to check username
							if (textfield.val() != "") {
								//$("body").scrollTo("#output");
								$("#output")
										.addClass(
												"alert alert-success animated fadeInUp")
										.html(
												"Welcome back "
														+ "<span style='text-transform:uppercase'>"
														+ textfield.val()
														+ "</span>");
								$("#output").removeClass(' alert-danger');
								$("input").css({
									"height" : "0",
									"padding" : "0",
									"margin" : "0",
									"opacity" : "0"
								});
								//change button text 
								$('button[type="submit"]').html("continue")
										.removeClass("btn-info").addClass(
												"btn-default").click(
												function() {
													$("input").css({
														"height" : "auto",
														"padding" : "10px",
														"opacity" : "1"
													}).val("");
												});

								//show avatar
								$(".avatar")
										.css(
												{
													"background-image" : "url('http://api.randomuser.me/0.3.2/portraits/women/35.jpg')"
												});
							} else {
								//remove success mesage replaced with error message
								$("#output")
										.removeClass(' alert alert-success');
								$("#output").addClass(
										"alert alert-danger animated fadeInUp")
										.html("sorry enter a username ");
							}
							//console.log(textfield.val());

						});
	});
</script>

<link rel="stylesheet" href="./css/styleLogin.css" type="text/css" />
<title>Connexion</title>
</head>
<body>

	<div class="container">
		<div class="login-container">
			<div id="output"></div>
			<h1 style="color: #4682B4;">BankApp</h1>
			<div class="avatar"></div>
			<div class="form-box">
				<form action="pageVerification.jsp" method="post">
					<input type="text" name="email" placeholder="email"> <input
						type="password" name="pwd" placeholder="password"> <input
						type="submit" value="Se connecter">
				</form>
			</div>
		</div>

	</div>

</body>
</html>