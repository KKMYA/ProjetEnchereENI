<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Eni Encheres</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body style="background-color: aqua">
<h1 class="text-center">ENI ENCHERES</h1>
<c:if test="${noUtilisateur==null}">
	<div class="container">
	    <div class="row justify-content-start">
	        <div class="col-auto">
	            <a href="./connexion" class="text-decoration-none">
	                <button class="btn btn-light" type="button" id="Connexion">
	                    Se connecter / S'inscrire
	                </button>
	            </a>
	  	</div>
</c:if>
<c:if test="${noUtilisateur!=null}">
		 <div class="row justify-content-start">
	        <div class="col-auto">
	            <a href="./affichageProfil" class="text-decoration-none">
	                <button class="btn btn-light" type="button" id="Connexion">
	                    Mon profil
	                </button>
	            </a>
	            <a href="./deconnexion" class="text-decoration-none">
	                <button class="btn btn-light" type="button" id="Deconnexion">
	                    Se déconnecter
	                </button>
	            </a>
	  	</div>

</c:if>

<div class="col-auto">
    <form id="categorieForm" action="./" method="get">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="categoriesDrop" name="categoriesDrop" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Catégories
            </button>
            <div class="dropdown-menu" aria-labelledby="Catégories">
                <c:forEach var="categorie" items="${listeDeCategories}">
                    <a class="dropdown-item" href="#" onclick="selectCategory('${categorie.libelle}');">${categorie.libelle}</a>
                </c:forEach>
            </div>
        </div>
    </form>
</div>

<form class="text-center justify-content-center d-flex align-items-center mt-4">
    <div class="w-25">
        <label for="InputFiltres" class="form-label"></label>
        <input type="search" class="form-control" id="InputFiltres" name="InputFiltres" aria-describedby="InputFiltres" placeholder="Filtrer">
    </div>

    <div class="input-group w-25 ms-3">
        <input type="search" class="form-control rounded" id="Rechercher" name="Rechercher" placeholder="Rechercher" aria-label="Search" aria-describedby="search-addon" />
        <a href ="./">
        	<button type="submit" class="btn btn-outline-primary" data-mdb-ripple-init>Rechercher</button>
        </a>
    </div>
</form>

<c:if test="${not empty listeArticles}">
	<c:forEach var="article" items="${listeArticles}">
	<c:set var="articleId" value="${article.noArticle}"></c:set>
		<form action="./DetailEnchere" method="post"> 
       	 <div class="row mt-4">
         	<div class="col-md-4 mb-4">
                	<div class="card">
                   		<h5 class="card-title"><c:out value="${article.nomArticle}" /></h5>
                    	<p class="card-text"><small class="text-muted"><c:out value="Mis en vente le : ${article.dateDebutEncheres}" /></small></p>
                     	<p class="card-text"><small class="text-muted"><c:out value="État de la vente : " /></small></p>                   
                     	<p class="card-text"><small class="text-muted"><c:out value="Prix :" /></small></p>                   
                    	<input type="hidden" id="articleId" name="articleId" value="${article.noArticle}" /> <!-- Ajoutez l'ID de l'article comme paramètre caché -->
                    	<button  type="submit">Afficher la vente</button>
                	</div>
				</div>
        	</div>
		</form>
	</c:forEach>
</c:if>
    <div class="container text-center">
        <!-- Le contenu du conteneur de la barre de navigation Bootstrap -->
    </div>
    </body>
    </html>
