<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>PANNEAU D'ADMINISTRATION</title>
	<%@include file="style.jsp"%>
	</head>
	
	<body>
	<%@include file="Header.jsp"%>
	<div class="container mt-5" >
		<h1> PANNEAU D'ADMINISTRATION </h1>
		
		 	<form action="./panelAdmin" method="post">
			        <label for="pseudo">Veuillez indiquer l'adresse e-mail de l'utilisateur dont vous souhaitez supprimer le compte ainsi que les ventes : </label>
			        <input type="text"
			            id="userDELETE"
			            name="userDELETE"
			            autofocus
			            
			            placeholder="exemple@xyz.com">
			        <button type="submit">Supprimer l'utilisateur</button>
			</form>
			<br>
		
			 <form action="./panelAdmin" method="post">
			        <label for="nom">Veuillez indiquer l'adresse e-mail de l'utilisateur à qui DONNER les droits Administrateur : </label>
			        <input type="text"
			            id="adminADD"
			            name="adminADD"
			            
			            placeholder="Adresse e-mail">
			        <button type="submit">Donner les droits d'administrateur</button>
			</form>
			<br>
			<form action="./panelAdmin" method="post">
			        <label for="nom">Veuillez indiquer l'adresse e-mail de l'utilisateur à qui RETIRER les droits Administrateur : </label>
			        <input type="text"
			            id="adminREMOVE"
			            name="adminREMOVE"
			            
			            placeholder="Adresse e-mail">
			        <button type="submit">Retirer les droits d'administrateur</button>	    
			</form>
			<br>
			 <form action="./panelAdmin" method="post">
			        <label for="nom">Veuillez indiquer une catégorie que vous souhaitez AJOUTER : </label>
			        <input type="text"
			            id="categorieADD"
			            name="categorieADD"
			            
			            placeholder="Categorie">
			        
			        <button type="submit">Ajouter la catégorie</button>
			</form>	
			<br>
			<form action="./panelAdmin" method="post">
			    <div class="form-group">
			        <label for="categorieChoix">Veuillez sélectionner la catégorie que vous souhaitez SUPPRIMER</label>
			        <select class="custom-select" id="categorieChoix" name="categorieChoix" required>
			            <option selected>Choisissez une catégorie</option>
			            <c:forEach items="${listeDeCategories}" var="categorie">
			                <option value="${categorie.noCategorie}">${categorie.libelle}</option>
			            </c:forEach>
			        </select>
			        <button type="submit">Supprimer la catégorie</button>
			    </div>
			</form>
		</div>
		<%@include file="Footer.jsp"%>
	</body>
</html>