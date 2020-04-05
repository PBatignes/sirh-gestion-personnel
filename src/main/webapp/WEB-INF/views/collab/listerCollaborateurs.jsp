<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
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
<link rel="stylesheet" href="../css/listerCollaborateurs.css">
</head>

<body>
	<div class="page">
		<div class="head">
			<h1>Les collaborateurs</h1>
			</br>
			<div class="recherche">
				<p>Rechercher un nom qui commence par :</p>
				<input class="imput-rech">
				<button>Rechercher</button>
			</div>
			</br>
			<div class="filtre">
				<p>Filtrer par département :</p>
				<select class="dep-select">
					<%
						List<Departement> listeDep = (List<Departement>) request.getAttribute("listeDep");
						for (Departement dep : listeDep) {
					%>
					<option value="<%=dep.getNom()%>"><%=dep.getNom()%></option>
					<%
						}
					%>
				</select>
			</div>

			<button>
				<a href="http://localhost:8080/sgp/collaborateurs/nouveau">Ajouter</a>
			</button>
		</div>
		<div class="corps">
			<div class="row">
				<%
					List<Collaborateur> listeCollabs = (List<Collaborateur>) request.getAttribute("listeCollabs");
					if (listeCollabs != null) {
						for (Collaborateur collab : listeCollabs) {
				%>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-header"><%=collab.getNom()%></div>
						<div class="card-contenu">
							<div class="col-md-4">
								<img src=<%=collab.getPhoto()%> alt="Photo collaborateur">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<ul>
										<%
											String func = collab.getIntitulePoste() == null ? "N/R" : collab.getIntitulePoste();
										%>
										<li>Fonction : <%=func%></li>
										<%
											String dep = collab.getDepartement() == null ? "N/R" : collab.getDepartement().getNom();
										%>
										<li>Département : <%=dep%></li>
										<li>Email : <%=collab.getEmailPro()%></li>
										<%
											String tel = collab.getNumTel() == null ? "N/R" : collab.getNumTel();
										%>
										<li>Téléphone : <%=tel%></li>
									</ul>
									<button><a href="http://localhost:8080/sgp/collaborateurs/editer?matricule=<%= collab.getMatricule() %>">Editer</a></button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
					}
					}
				%>
			</div>
		</div>
	</div>


</body>
</html>