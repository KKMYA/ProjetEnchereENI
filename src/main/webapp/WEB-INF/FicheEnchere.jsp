<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html>
        <head>
            <title>Fiche enchère</title>
            <meta charset="utf-8"/>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
        </head>
        <body>
       	<!-- Page Enchérir. Condition: Connecté et enchère date pas terminée ( pas forcément commencé)  -->
            <h1>Détail vente</h1>
            
            <!-- Page enchere finie A voir avec la Servlet. Condition: Enchère terminée + id du gagnant de l'enchere != de moi-->
            <h1> a remporté l'enchère</h1>
            <!-- Page vente remporté. Condition: Enchère terminée + id du gagnant = moi -->


            <h1>Vous avez remporté la vente</h1>
            
            <img>
            <!-- Titre de l'enchère -->
            <h2>${article.nomArticle}</h2>

            <!--Description du produit récupéré-->
            <p>Description: ${article.description} </p>

            <!--Catégorie affilié lors de la création de la vente-->
            <p>Catégorie: ${categorie.libelle}</p>

            <!--Meilleure offre en temps réel-->
            <p>Meilleure offre: ${article.prixVente}</p> 

            <p>Mise à prix: ${article.miseAPrix} </p>

            <p>Fin de l'enchère: ${article.dateFinEncheres }</p>
			
            <p>Retrait: ${retrait.rue} - ${retrait.codePostal} ${retrait.ville }</p>
            
			<!-- Récupéré grace à Servlet Fiche Enchère -->
            <p>Vendeur: ${utilisateur.pseudo}</p>
			<!-- Page enchère -->
            <form method="post">
                <label>Ma proposition: </label>
                <input  type="number" id="proposition" name="proposition" required>
                <input type="submit" value="Enchérir">
            </form>
            <!-- Page enchère non débutée IdVendeur = moi -->
            <button>Modifier</button>
            <!-- Page enchère finie -->
            <button>Retour</button>
            
           	<!-- Page vente remportée -->
           	<button> Retrait effectué</button>
		
        </body>
        <footer>

        </footer>
    </html>