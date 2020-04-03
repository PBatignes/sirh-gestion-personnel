<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>SGP - App</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>

<body>
	<h1>Nouveau Collaborateur</h1>
	<% String s = (String) request.getAttribute("erreurNumSecu"); %>
	<form name="creerForm" method="post" action="http://localhost:8080/sgp/collaborateurs/nouveau">
		<div class="form-group">
			<label for="imputNom">Nom</label> 
			<input type="text" class="form-control" name="nom" required>
		</div>
		<div class="form-group">
			<label for="imputPrenom">Prénom</label> 
			<input type="text" class="form-control" name="prenom" required>
		</div>
		<div class="form-group">
			<label for="imputDateNaiss">Date de naissance</label> 
			<input type="date" class="form-control" name="dateNaiss" required>
		</div>
		<div class="form-group">
			<label for="imputAdresse">Adresse</label> 
			<input type="text" class="form-control" name="adresse" required>
		</div>
		<div class="form-group">
			<label for="imputNumSecu">Numéro de sécurité sociale</label> 
			<input type="text" class="form-control" name="numSecu" required>
			<small>
			<%= s %>
			</small>
		</div>
		<button type="submit" class="btn btn-primary">Créer</button>
	</form>
</body>
</html>