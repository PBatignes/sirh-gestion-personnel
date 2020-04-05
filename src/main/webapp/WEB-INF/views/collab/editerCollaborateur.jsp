<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>SGP - App</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/editerCollaborateurs.css">
</head>

<body>

	<%
		List<Departement> listeDep = (List<Departement>) request.getAttribute("listeDep");
		List<Collaborateur> listeCollabs = (List<Collaborateur>) request.getAttribute("listeCollabs");
		for (Collaborateur collab : listeCollabs) {
	%>

	<div class="page">
		<div class="col-gauche">
			<img src=<%=collab.getPhoto()%> alt="Photo collaborateur">
		</div>
		<div class="col-droite">
			<h1><%=collab.getNom() + " " + collab.getPrenom() + " - " + collab.getMatricule()%></h1>
			<form id="editerForm" method="post"
				action="http://localhost:8080/sgp/collaborateurs/editer?matricule=<%=collab.getMatricule()%>">
				<div id="accordion">
					<div class="card">
						<div class="card-header" id="headingOne">
							<h5 class="mb-0">
								<a class="btn btn-link" data-toggle="collapse"
									data-target="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne">Identité</a>
							</h5>
						</div>

						<div id="collapseOne" class="collapse show"
							aria-labelledby="headingOne" data-parent="#accordion">

							<div class="card-body">
								<label for="civ">Civilité</label>
								<select id="civ">
									<option value="mr">Mr</option>
									<option value="mme">Mme</option>
								</select>

								<label>Nom</label>
								<input type="text"
									value=<%=collab.getNom()%> readonly>

								<label>Prénom</label>
								<input type="text"
									value=<%=collab.getPrenom()%> readonly>

								<label>Date de naissance</label>
								<input type="date"
									value=<%=collab.getDateNaissance()%> readonly>

								<label for="adresse">Adresse</label>
								<textarea id="adresse" name="adresse" rows="4" cols="50" required><%=collab.getAdresse()%></textarea>

								<label>Numéro de sécurité sociale</label>
								<input type="text"
									value=<%=collab.getNumSecu()%> readonly>

								<label for="numTel">Téléphone</label>
								<%
									String s = collab.getNumTel() == null ? "" : collab.getNumTel();
								%>
								<input type="text" id="numTel" name="numTel" value=<%=s%>>

							</div>

						</div>
					</div>
					<div class="card">
						<div class="card-header" id="headingTwo">
							<h5 class="mb-0">
								<a class="btn btn-link collapsed" data-toggle="collapse"
									data-target="#collapseTwo" aria-expanded="false"
									aria-controls="collapseTwo">Poste</a>
							</h5>
						</div>
						<div id="collapseTwo" class="collapse"
							aria-labelledby="headingTwo" data-parent="#accordion">

							<div class="card-body">
								<label for="intitulePoste">Intitulé du poste</label>
								<%
									s = collab.getIntitulePoste() == null ? "" : collab.getIntitulePoste();
								%>
								<input type="text" id="intitulePoste" name="intitulePoste"
									value=<%=s%>>

								<label for="departement">Département</label>
								<select id="departement" name="departement" form="editerForm">
									<%
										String d = collab.getDepartement() == null ? "Choissisez un département" : collab.getDepartement().getNom();
									%>
									<option disabled selected><%= d %></option>
									<option value=<%=listeDep.get(0).getNom() %>>Comptabilite</option>
									<option value=<%=listeDep.get(1).getNom() %>>Ressources Humaines</option>
									<option value=<%=listeDep.get(2).getNom() %>>Informatique</option>
									<option value=<%=listeDep.get(3).getNom() %>>Administratif</option>
								</select>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header" id="headingThree">
							<h5 class="mb-0">
								<a class="btn btn-link collapsed" data-toggle="collapse"
									data-target="#collapseThree" aria-expanded="false"
									aria-controls="collapseThree">Coordonnées Bancaires</a>
							</h5>
						</div>
						<div id="collapseThree" class="collapse"
							aria-labelledby="headingThree" data-parent="#accordion">

							<div class="card-body">
								<label for="banque">Banque</label>
								<%
									s = collab.getBanque() == null ? "" : collab.getBanque();
								%>
								<input type="text" id="banque" name="banque"
									value=<%=s%>>

								<label for="bic">bic</label>
								<%
									s = collab.getBic() == null ? "" : collab.getBic();
								%>
								<input type="text" id="bic" name="bic"
									value=<%=s%>>

								<label for="iban">iban</label>
								<%
									s = collab.getIban() == null ? "" : collab.getIban();
								%>
								<input type="text" id="iban" name="iban"
									value=<%=s%>>
							</div>

						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Sauvegarder</button>
			</form>
		</div>

	</div>
	<%
		}
	%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>