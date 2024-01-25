<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Modifier mon compte</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    </head>

    <body>
        <h1>Modifier mon profil</h1>

        
         <!-- car présence de mdp-->
				<form action="./modificationProfil" method="post">

                <label for="pseudo">Pseudo: </label>
                <input type="text"
                id="pseudo" 
                name="pseudo" 
                autofocus
                
                placeholder="${utilisateur.pseudo}"
                pattern="[A-Z a-z\W]{,}"
                maxlength="30"
                title="3 caractères minimum. "><br>
                

                <label for="nom">Nom: </label>
        	    <input type="text"
                id="nom" 
                name="nom" 
                
                placeholder="${utilisateur.nom}"
                pattern="[A-Z a-z\W+]{,}"
                title="3 caractères minimum. Pas de caractères spéciaux acceptés. "> 
         
                <label for="prenom">Prénom:</label>
                <input type="text"
                id="prenom" 
                name="prenom" 
                
                placeholder="${utilisateur.prenom}"
                pattern="[A-Z a-z\W]{3,}"
                title="3 caractères minimum. Pas de caractères spéciaux acceptés."><br>
			
                <label for="email">Email:</label>
                <input type="email"
                id="email" 
                name="email" 
                
                placeholder="${utilisateur.email}"
                pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" 
                size="30"> 

                <!-- Regex -->
                <label for="telephone">Téléphone: </label>
                <input type="tel"
                id="telephone" 
                name="telephone" 
                
                placeholder="${utilisateur.telephone}"
                pattern="+33{3}- [0-9]{1}-[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}"><br>

                <label for="rue">Rue: </label>
                <input type="text"
                id="rue" 
                name="rue" 
                
                placeholder="${utilisateur.rue}"
                pattern="[A-Z a-z\w]{3,}"
                title="">

                <label for="code_postal">Code postal: </label>
                <input type="number"
                id="code_postal" 
                name="code_postal" 
                
                maxlength="5"
                placeholder="${utilisateur.codePostal}">

                <label for="ville">Ville:</label>
                <input type="text"
                id="ville" 
                name="ville" 
                placeholder="${utilisateur.ville}"
                title=""><br>

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
                <p>Crédit: ${utilisateur.credit }</p>
                <input type="submit" value="Enregistrer">
                </form>
                <form action="./suppressionProfil" method="post">
                
                <input type="submit" value="Supprimer mon compte">
                
                </form>
       

    </body>

    <footer>

    </footer>

</html>