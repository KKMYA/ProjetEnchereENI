<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Entrer nouveau Mot de passe</title>
</head>
<body>
<form action="./setNewPW" method="post">
<div class="row mb-3 w-50">
  <label for="EntrerMDP" class="col-sm-2 col-form-label">Entrer nouveau mot de passe</label>
  <div class="col-sm-10">
    <input type="password" class="form-control" id="EntrerMDP" name="EntrerMDP">
  </div>
</div>
  <div class="row mb-3 w-50">
    <label for="ConfirmMDP" class="col-sm-2 col-form-label">Confirmer nouveau mot de passe</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="ConfirmMDP"name="ConfirmMDP">
    </div>
  </div>
  <div>
    <button type="submit" class="btn btn-primary">Valider</button>
  </div>
</form>
</body>
</html>