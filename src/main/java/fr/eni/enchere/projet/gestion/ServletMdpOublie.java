package fr.eni.enchere.projet.gestion;

import fr.eni.enchere.projet.bll.RecuperationMDP;
import fr.eni.enchere.projet.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//import static fr.eni.enchere.projet.bo.Utilisateur.email;

@WebServlet("/MDP_oublié")
public class ServletMdpOublie extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Requête d'affichage de la page entrée mail
        request.getRequestDispatcher("WEB-INF/MDP_oublié_mail.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //Récupération de l'info mail de la première page
        String email = request.getParameter("Email_mdp_oublié");

        //Vérification de l'adresse en BDD
        if (RecuperationMDP.CheckMail(email)) {
            //Créer et Stocker random key en BDD
            RecuperationMDP recuperationMDP = new RecuperationMDP();
            recuperationMDP.setRandomKey(Utilisateur.getRandomKey(), email);


            //Redirection vers seconde jsp pour changer le mdp
            request.getRequestDispatcher("WEB-INF/MDP_oublié_new_mdp.jsp").forward(request,response);
        } else{
            //Message d'erreur adresse non existante en BDD
            request.setAttribute("error","L'adresse mail n'existe pas");
            request.getRequestDispatcher("/MDP_oublié_mail.jsp").forward(request, response);

        }

    }



}
