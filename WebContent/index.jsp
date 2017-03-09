<!DOCTYPE html>
<html>
<head>

<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h1>Login de connexion</h1>
</div>

<form action="login.html" method="post">
<div class="input-group input-group-lg">
  		Nom <input type="text" class="form-control" placeholder="Votre nom.." aria-describedby="sizing-addon1" id="nom" name="nom">
	</div>
	<div class="input-group input-group-lg">
  		Login <input type="text" class="form-control" placeholder="Votre login.." aria-describedby="sizing-addon1" id="login" name="login">
	</div>
	<div class="input-group input-group-lg">
  		Mot de passe <input type="text" class="form-control" placeholder="Votre mot de passe.." aria-describedby="sizing-addon1" id="mdp" name="mdp">
	</div>
	<p><input type = "submit" value = "Valider"></p>
</form>

</body>
</html>