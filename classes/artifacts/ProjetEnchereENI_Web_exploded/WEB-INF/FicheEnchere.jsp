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
            <h2></h2>

            <!--Description du produit récupéré-->
            <p>Description: </p>

            <!--Catégorie affilié lors de la création de la vente-->
            <p>Catégorie: </p>

            <!--Meilleure offre en temps réel-->
            <p>Meilleure offre:</p> 

            <p>Mise à prix: </p>

            <p>Fin de l'enchère: </p>

            <p>Retrait: </p>

            <p>Vendeur: </p>

            <form method="post">
                <label>Ma proposition: </label>
                <input  type="number" id="proposition" name="proposition" required>
                <input type="submit" value="Enchérir">
            </form>

        </body>
        <footer>

        </footer>
    </html>