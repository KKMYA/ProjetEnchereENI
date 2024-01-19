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
  <h2>Ajouter un article à vendre</h2>
  
  
    <!--Définition du formulaire d'ajout d'article -->
  <form method="post" action="./ServletAjoutArticle">
    <div class="form-group">
      <label for="nomArticle">Nom de l'article :</label>
      <input type="text" class="form-control" id="nomArticle" name="nomArticle" placeholder="Entrez le nom de l'article" required>
    </div>
    <div class="form-group">
      <label for="description">Description :</label>
      <textarea class="form-control" id="description" name="description" rows="3" placeholder="Entrez la description du produit" required></textarea>
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
      <input type="number" class="form-control" id="prix" name="prix" placeholder="Entrez le prix du produit" required>
    </div>
    <div class="form-group">
      <label for="photo">URL de la photo :</label>
      <input type="url" class="form-control" id="photo" name="photo" placeholder="Entrez l'URL de la photo de l'article">
        <div class="fichier btn btn-primary">
            Changer Photo
            <input type="file" name="fichier"/>
        </div>
    </div>
    
    
    <button type="submit" class="btn btn-primary">Ajouter l'article</button>
    <a href="index.html" type="submit" class="btn btn-secondary"> Annuler </a>
    
  </form>
</div>



</body>
</html>