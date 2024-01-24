<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PANNEAU D'ADMINISTRATION</title>
</head>
<body>
<h1> PANNEAU D'ADMINISTRATION </h1>

 <form action="./inscription" method="post"> <!-- car prÃ©sence de mdp-->

 		<fieldset>   
                <label for="pseudo">Veuillez indiquer le pseudo d'un utilisateur à supprimer et supprimer les ventes liées à cet utilisateur : </label>
                <input type="text"
                id="pseudo" 
                name="pseudo" 
                autofocus
                required
                placeholder="pseudo">
                
                <br>

                <label for="nom">Veuillez indiquer une catégorie que vous souhaitez AJOUTER : </label>
                <input type="text"
                id="categorieADD" 
                name="categorieADD" 
                required
                placeholder="Categorie"> 
                
                <br>
                
                <label for="nom">Veuillez indiquer le pseudo de l'utilisateur à qui DONNER les droits Administrateur : </label>
                <input type="text"
                id="adminADD" 
                name="adminADD" 
                required
                placeholder="Pseudo"> 
                
                <br>
                
                <label for="nom">Veuillez indiquer le pseudo de l'utilisateur à qui RETIRER les droits Administrateur : </label>
                <input type="text"
                id="adminDELETE" 
                name="adminDELETE" 
                required
                placeholder="Pseudo"> 
                
                <br>
                
          		<div class="form-group">
    			<label for="categorieChoix"> Veuillez sélectionner la catégorie que vous souhaitez SUPPRIMER</label>
    			<select class="custom-select" id="categorieChoix" name="categorieChoix" required>
        		<option selected>Choisissez une catégorie</option>
        		<c:forEach items="${listeDeCategories}" var="categorie">
            		<option value="${categorie.noCategorie}">${categorie.libelle}</option>
        		</c:forEach>
    </select>
</div>
		</fieldset>
	</form>
</body>
</html>