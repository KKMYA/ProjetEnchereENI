package fr.eni.enchere.projet.gestion;

import fr.eni.enchere.projet.bll.CorrespondanceMailID;
import fr.eni.enchere.projet.bll.RecuperationMDP;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

//import static fr.eni.enchere.projet.bo.Utilisateur.email;

@WebServlet(urlPatterns = "/forgottenPW")
public class ServletMdpOublie extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// Requête d'affichage de la page entrée mail
		request.getRequestDispatcher("WEB-INF/forgottenPW.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		// Récupération de l'info mail de la première page
		String email = request.getParameter("Email_mdp_oublié");
		String error = "L'adresse mail n'existe pas";
		// Vérification de l'adresse en BDD
		if (RecuperationMDP.CheckMail(email) == true) {
			// Créer et Stocker random key en BDD
			request.getSession().setAttribute("email", email);
			RecuperationMDP recuperationMDP = new RecuperationMDP();
			recuperationMDP.setRandomKey(Utilisateur.getRandomKey(), email);
			String affichageChampsMDP = "valide";
			request.setAttribute("affichageChampsMDP", affichageChampsMDP);
			
			request.getRequestDispatcher("WEB-INF/forgottenPWnewPW.jsp").forward(request, response);

		} else {
			// Message d'erreur adresse non existante en BDD
			request.setAttribute("error", error);
			request.getRequestDispatcher("WEB-INF/forgottenPW.jsp").forward(request, response);

		}

	}

}
