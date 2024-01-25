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
            
            <!-- Page vente remportée. Condition: Enchère terminée + id du gagnant = moi -->
            <h1>Vous avez remporté la vente</h1>
            
            <!-- Information Enchère -->
	            <!-- Image à récupérer -->
	            <img>
	            <!-- Titre de l'enchère -->
	            <h2>${ArticleEnVente.nomArticle }</h2>
	
	            <!--Description du produit récupéré-->
	            <p>Description: ${ArticleEnVente.description} </p>
	
	            <!--Catégorie affilié lors de la création de la vente-->
	            <p>Catégorie: ${CategorieArticle.libelle}</p>
	
	            <!--Meilleure offre en temps réel-->
	            <p>Meilleure offre: ${ArticleEnVente.prixVente}</p> 
	
	            <p>Mise à prix: ${ArticleEnVente.miseAPrix} </p>
	
	            <p>Fin de l'enchère: ${ArticleEnVente.dateFinEncheres }</p>
				
	            <p>Retrait: ${LieuDeRetrait.rue} ${LieuDeRetrait.codePostal} ${LieuDeRetrait.ville }</p>
	            
				<!-- Récupéré grace à Servlet Fiche Enchère -->
	            <p>Vendeur: ${PseudoUtilisateur.pseudo}</p>
			<!-- Boutons cliquable fin de page -->
				<!-- Page enchère. Conditions: Connecté + id vendeur != id utilisateur-->
	            <form method="post">
	                <label>Ma proposition: </label>
	                <input  type="number" id="proposition" name="proposition" required>
	                <input type="submit" value="Enchérir">
	            </form>
	            
	            <!-- Page enchère Conditions: non débutée IdVendeur = moi -->
	            <button>Modifier</button>
	            
	            <!-- Page enchère finie. Conditions: Enchère finie + idgagnant != de moi -->
	            <button>Retour</button>
	            
	           	<!-- Page vente remportée. Conditions Enchère finie + idgagnant = moi-->
	           	<button> Retrait effectué</button>

        </body>
        <footer>

        </footer>
    </html>