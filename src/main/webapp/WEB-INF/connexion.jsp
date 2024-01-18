<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Connexion</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<form action="./connexion" method="post"text-center justify-content-center align-self-center">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

  <!-- Entrée Mail -->
  <div class="form-outline mx-auto mb-4" style="width: 25%;">
    <input type="email" id="email" name="email" class="form-control" />
    <label class="form-label" for="email">Adresse Mail</label>
  </div>

  <!-- Entrée MDP -->
  <div class="form-outline mx-auto mb-4" style="width: 25%;">
    <input type="password" id="mot_de_passe" name="mot_de_passe" class="form-control" />
    <label class="form-label" for="mot_de_passe">Mot de Passe</label>
  </div>

  <!-- Layout colonne -->
  <div class="row mx-auto mb-4" >
    <div class="col d-flex justify-content-center " style="width: 40%">
      <!-- Case se souvenir de moi -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="Souvenir" name="souvenir" checked />
        <label class="form-check-label" for="Souvenir"> Se souvenir de moi </label>
      </div>
    </div>

    <div class="col">
      <!-- Lien Mot de passe oublié -->
      <a href="#">Mot de passe oublié?</a>
    </div>
  </div>

  <!-- Bouton validation formulaire -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Se connecter</button>

  <!-- Bouton d'inscription -->
  <div class="text-center">
    <p>Pas inscrit? <a href="./Inscription.html">S'inscrire</a></p>

  </div>
</form>
</body>
</html>
