<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Ajouter un Article</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<div class="container mt-5">

   <%--<%@include file="Test.html" %> --%> 
  <h2>Ajouter un article à vendre</h2>
  
  
    <!--Définition du formulaire d'ajout d'article -->
  <form method="post" action="./AjoutArticle">
    <div class="form-group">
      <label for="nom_article">Nom de l'article :</label>
      <input type="text" class="form-control" id="nom_article" name="nom_article" placeholder="Entrez le nom de l'article" required>
    </div>
    <div class="form-group">
      <label for="description">Description :</label>
      <textarea class="form-control" id="description" name="description_article" rows="3" placeholder="Entrez la description du produit" required></textarea>
    </div>
    
    
      <!--Formulaire d'ajout de la catégorie en menu déroulant -->
    <div class="form-group">
        <label for="categorieChoix"> Catégorie</label>
        <select class="custom-select" id="categorieChoix" name="categorieChoix" required>
          <option selected>Choisissez une catégorie</option>
          <option value="1">Informatique</option>
          <option value="2">Ameublement</option>
          <option value="3">Vêtements</option>
          <option value="4">Sports et Loisirs</option>
        </select>

    </div>
    
    
    <div class="form-group">
      <label for="prix">Prix en points:</label>
      <input type="number" class="form-control" id="prix" name="prix_initial_de_vente" placeholder="Entrez le prix du produit" required>
    </div>
    <div class="form-group">
      <label for="photo">URL de la photo :</label>
      <input type="url" class="form-control" id="photo" name="photo" placeholder="Entrez l'URL de la photo de l'article">
        <div class="fichier btn btn-primary">
            Changer Photo
            <input type="file" name="fichier"/>
        </div>
    </div>
    
            <!--Bloc Adresse du retrait -->
    </div>
      <div class="form-group">
          <label for="ville">Ville</label>
          <input type="text" id="ville" name="villeRetrait" class="form-control" >


          <label for="code_postal">Code Postal (format:"00000")</label>
          <input type="text" id="code_postal" name="code_postal" class="form-control" pattern="[0-9]*">


          <label for="adresse">Adresse</label>
          <input type="text" id="adresse" name="rueRetrait" class="form-control" />



      </div>

      <button type="submit" class="btn btn-primary">Ajouter l'article</button>
      <a href="./WEB-INF/index.jsp" type="submit" class="btn btn-secondary"> Annuler </a>

  </form>
</div>


</body>
</html>

