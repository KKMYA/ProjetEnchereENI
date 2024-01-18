<!DOCTYPE html>

<html>
    <head>
        <title>Création de compte</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    </head>

    <body>
        <h1>Mon profil</h1>

        
        <form action="./inscription" method="post"> <!-- car présence de mdp-->

            <!--Plus de Fieldset (visible) avec l'ajout du bootstrap-->
            <fieldset>   
                <label for="pseudo">Pseudo: </label>
                <input type="text"
                id="pseudo" 
                name="pseudo" 
                autofocus
                required
                placeholder="pseudo"
                pattern="[A-Z a-z\W]{,}"
                maxlength="30"
                title="3 caractères minimum. "><br>

                <label for="nom">Nom: </label>
                <input type="text"
                id="nom" 
                name="nom" 
                required
                placeholder="nom"
                pattern="[A-Z a-z\W+]{,}"
                title="3 caractères minimum. Pas de caractères spéciaux acceptés. "> 

                <label for="prenom">Prénom:</label>
                <input type="text"
                id="prenom" 
                name="prenom" 
                required
                placeholder="prénom"
                pattern="[A-Z a-z\W]{3,}"
                title="3 caractères minimum. Pas de caractères spéciaux acceptés."><br>

                <label for="email">Email:</label>
                <input type="email"
                id="email" 
                name="email" 
                required
                placeholder="email"
                pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" 
                size="30"> 

                <!-- Regex -->
                <label for="telephone">Téléphone: </label>
                <input type="tel"
                id="telephone" 
                name="telephone" 
                required
                placeholder="+33 6 00 00 00 00"
                pattern="+33{3}- [0-9]{1}-[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}"><br>

                <label for="rue">Rue: </label>
                <input type="text"
                id="rue" 
                name="rue" 
                required
                placeholder="rue"
                pattern="[A-Z a-z\w]{3,}"
                title="">

                <label for="code_postal">Code postal: </label>
                <input type="number"
                id="code_postal" 
                name="code_postal" 
                required
                maxlength="5"
                placeholder="code postal">

                <label for="ville">Ville:</label>
                <input type="text"
                id="ville" 
                name="ville" 
                required
                placeholder="ville"
                pattern="[A-Z a-z]{3,}"
                title=""><br>

                <label for="mot_de_passe">Mot de passe: </label>
                <input type="password"
                id="mot_de_passe" 
                name="mot_de_passe" 
                required
                placeholder="mot de passe"
                pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,20}"
                title=" 8 caractères minimum. Une majuscule, une miniscule et un caractère spécial sont obligatoires">

                <label for="confirmation">Confirmation: </label>
                <input type="password"
                id="confirmation" 
                name="confirmation" 
                required
                placeholder="confirmation"
                pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}[A-Z a-z\W]{8,}"><br><br><br>

                <input type="submit" value="Créer">
                <input type="button" value="Annuler">
            </fieldset>

        </form>

    </body>

    <footer>

    </footer>

</html>