<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Mot de Passe oublié?</title>
</head>
<body>
	<div class="col-md-6 row g-3">Mot de Passe oublié?</div>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
	<form action="./forgottenPW" method="post">
		<div class="form-group w-50 center col-md-6 row g-3">
			<label for="Email_mdp_oublié">Adresse Mail</label> <input
				type="email" class="form-control" id="Email_mdp_oublié"
				name="Email_mdp_oublié"
				placeholder="Veuillez entrer votre adresse mail" required> <small
				id="resize" class="form-text text-muted"></small>
		</div>
		<div class="col-sm-10 row g-3">
			<button type="submit" class="btn btn-primary">Envoyer</button>
		</div>
	</form>	
</body>
</html>