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
	            <a href="./connexion" class="text-decoration-none">
	                <button class="btn btn-light" type="button" id="Connexion">
	                    Mon profil
	                </button>
	            </a>
	            
	  	</div>

</c:if>
<div class="col-auto">
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="categoriesDrop" name="categoriesDrop" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Catégories
        </button>
        <div class="dropdown-menu" aria-labelledby="Catégories">
            <c:forEach var="article" items="${categorieInformatique}">
                <a class="dropdown-item" href="#">Informatique ${article}</a>
            </c:forEach>

            <c:forEach var="article" items="${categorieAmeublement}">
                <a class="dropdown-item" href="#">Ameublement ${article}</a>
            </c:forEach>

            <c:forEach var="article" items="${categorieVetements}">
                <a class="dropdown-item" href="#">Vêtements ${article}</a>
            </c:forEach>

            <c:forEach var="article" items="${categorieSport}">
                <a class="dropdown-item" href="#">Sport et Loisirs ${article}</a>
            </c:forEach>
        </div>
    </div>
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

<c:if test="${listeDeTousLesArticles != null}">
    <c:forEach var="article" items="${listeDeTousLesArticle}">
<div class="row mt-4">
    <div class="col-md-4 mb-4">
        <div class="card">
            <h5 class="card-title">${article.nomArticle}</h5>
            <p class="card-text"> ${article.description_article} </p>
            <p class="card-text"><small class="text-muted">${article.vendeurArticle}</small></p>
        </div>
    </div>
        <%--<div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">${article.nomArticle}</h5>
                <p class="card-text">${article.description_article}</p>
                <p class="card-text"><small class="text-muted">${article.vendeurArticle}</small></p>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 3</h5>
                <p class="card-text">Description article 3</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 3</small></p>
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 4</h5>
                <p class="card-text">Description article 4</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 4</small></p>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 5</h5>
                <p class="card-text">Description article 5</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 5</small></p>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 6</h5>
                <p class="card-text">Description article 6</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 6</small></p>
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 7</h5>
                <p class="card-text">Description article 7</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 7</small></p>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 8</h5>
                <p class="card-text">Description article 8</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 8</small></p>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card">
                <h5 class="card-title">Article 9</h5>
                <p class="card-text">Description article 9</p>
                <p class="card-text"><small class="text-muted">Vendu par: Vendeur 9</small></p>
            </div>
        </div>
    </div>--%>
        </c:forEach>
</c:if>
    <div class="container text-center">
        <!-- Le contenu du conteneur de la barre de navigation Bootstrap -->
    </div>
    </body>
    </html>
