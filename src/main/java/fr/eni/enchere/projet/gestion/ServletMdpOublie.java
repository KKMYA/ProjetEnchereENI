package fr.eni.enchere.projet.gestion;

import fr.eni.enchere.projet.bll.RecuperationMDP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//import static fr.eni.enchere.projet.bo.Utilisateur.email;

@WebServlet
public class ServletMdpOublie extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //RecuperationMDP.CheckMail(email);


    }



}
