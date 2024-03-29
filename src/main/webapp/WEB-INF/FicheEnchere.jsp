<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <title>Fiche enchère</title>
            <meta charset="utf-8"/>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
        </head>
        <body>
        	<!-- Page Enchérir -->
            <h1>Détail vente</h1>
            <!-- Page enchere finie -->
            <h1>${utilisateur} a remporté l'enchère</h1>
            <!-- Page vente remportée -->
            <h1>Vous avez remporté la vente</h1>
            
            <img>
            <!-- Titre à générer -->
            <h2>${ArticleEnVente.nomArticle }</h2>

            <!--Description du produit récupéré-->
            <p>Description: ${ArticleEnVente.description} </p>

            <!--Catégorie affilié lors de la création de la vente-->
            <p>Catégorie: ${ArticleEnVente.noCategorie}</p>

            <!--Meilleure offre en temps réel-->
            <p>Meilleure offre:</p> 

            <p>Mise à prix: ${ArticleEnVente.miseAPrix} </p>

            <p>Fin de l'enchère: ${ArticleEnVente.dateFinEncheres }</p>
			
			<!-- A faire avec une Servlet -->
            <p>Retrait: </p>

            <p>Vendeur: ${ArticlEenVente.NoUtilisateur.Pseudo}</p>

			<!-- Page enchère -->
            <form method="post">
                <label>Ma proposition: </label>
                <input  type="number" id="proposition" name="proposition" required>
                <input type="submit" value="Enchérir">
            </form>
            <!-- Page enchère finie -->
            <button value="Retour"></button>
            
           	<!-- Page vente remportée -->
           	<button value="Retrait effectué"></button>

        </body>
        <footer>

        </footer>
    </html>