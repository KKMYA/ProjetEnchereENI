<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--HEADER-->
    <header class="container-fluid fixed-header" >
        <a href="./">
        	<img class="logo-encherama logo-top" src="Images/logo.png" />
        </a>
        <nav class="top-navbar">
            <!-- Partie connecté-->
           	<c:if test="${noUtilisateur!=null}"> 
	            <a href="./"> Enchères</a>
	            <a href="./AjoutArticle"> Vendre un article</a>
	            <a href="./affichageProfil"> Mon profil </a>
	            <a href="./deconnexion"> Déconnexion</a>
	         </c:if>
	         <!-- Partie déco-->
            <c:if test="${noUtilisateur==null}">
	            <a href="./inscription">S'inscrire</a>
	            <a href="./connexion">Se connecter</a>
	        </c:if>
        </nav>
    </header>
