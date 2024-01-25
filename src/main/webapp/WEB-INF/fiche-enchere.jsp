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
            <h1>Détail vente</h1>
            <img>
            <!-- Titre à générer -->
            <h2>${article.nomArticle}</h2>

            <!--Description du produit récupéré-->
            <c:if test="${article!==null}">
            <p>Description: ${article.description_article} </p>


            <!--Catégorie affilié lors de la création de la vente-->
            <p>Catégorie: ${article.catégorieIndex} </p>

            <!--Meilleure offre en temps réel-->
            <p>Meilleure offre: ${article.offre}</p>

            <p>Mise à prix:${article.prixInitial} </p>

            <p>Fin de l'enchère:${article.dateFin} </p>

            <p>Retrait:${article.adresse} </p>

            <p>Vendeur:${article.vendeurArticle} </p>
            </c:if>
            <form method="post">
                <label>Ma proposition: </label>
                <input  type="number" id="proposition" name="proposition" required>
                <input type="submit" value="Enchérir">
            </form>

        </body>
        <footer>

        </footer>
    </html>