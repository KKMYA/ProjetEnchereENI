<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="headerFooterStyle.css">
<title>Mon Profil</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<div class="Infos Profil">
		<h3>Mon profil</h3>
		<div class="container ">

			<div class="row">
				<div class="col-md-4">
					<div class="photo-profil">
						<img
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoF6HmYDfPRJUC9M_0U2I2JFoaqWJxwmFWxA&usqp=CAU"
							alt="" />
						<div class="fichier btn btn-primary">
							Changer Photo <input type="file" name="fichier" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h5>${utilisateur.prenom} ${utilisateur.nom}</h5>
						<p class="note vendeur">
							note vendeur: <span>8/10</span>
						</p>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="AProposNav" data-toggle="tab" href="#APropos" role="tab"
								aria-controls="home" aria-selected="true">A propos</a></li>
							<li class="nav-item"><a class="nav-link" id="AVendreNav"
								data-toggle="tab" href="#AVendre" role="tab"
								aria-controls="AVendre" aria-selected="false">Mes objets à
									vendre</a></li>
							<li class="nav-item"><a class="nav-link" id="VendusNav"
								data-toggle="tab" href="#Vendus" role="tab"
								aria-controls="Vendus" aria-selected="false">Mes objets
									vendus</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-2">
					<form action="./modificationProfil" method="get">
						<input type="submit" class="modifier-profil-btn"
							name="modifierProfil" value="Modifier profil" />
					</form>
					<a href="${pageContext.request.contextPath}/"> <input
						type="submit" class="modifier-profil-btn" name="modifierProfil"
						value="Retour à l'accueil" />
					</a>

				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="profile-work">
						<p>Catégories d'objets en vente:</p>
						<p>Informatique</p>
						<p>Ameublement</p>
						<p>Vêtements</p>
						<p>Sports et Loisirs</p>
					</div>
				</div>
				<div class="col-md-8">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="APropos"
							role="tabpanel" aria-labelledby="home-tab">
							<div class="row">
								<div class="col-md-6">
									<label>Pseudo</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.pseudo}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Nom</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.nom}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Prenom</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.prenom}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.email}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Téléphone</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.telephone}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Rue</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.rue}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Code Postal</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.codePostal}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Ville</label>
								</div>
								<div class="col-md-6">
									<p>${utilisateur.ville}</p>
								</div>
							</div>
						</div>
						<c:if test="${not empty listeArticles}">
							<div class="tab-pane fade" id="AVendre" role="tabpanel"
								aria-labelledby="profile-tab">
								<div class="card">
									<div class="col-md-6">
										<div class="row mt-4">
											<c:forEach var="article" items="${listeArticles}">
												<div class="col-md-4 mb-4">
													<div class="card">
														<h5 class="card-title">${article.nomArticle}</h5>
														<p class="card-text">${article.description}</p>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</c:if>


					</div>
				</div>
				<c:if test="${utilisateur.administrateur == true}">
					<form action="./panelAdmin" method="get">
						<button id="lienPanelAdmin" name="lienPanelAdmin"
							value="${utilisateur.noUtilisateur}">PANEL ADMIN</button>
					</form>
				</c:if>
</body>
</html>