package fr.eni.enchere.projet.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();   
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		String pseudo = request.getParameter("pseudo");
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone =request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("mot_de_passe");
		String confirmationMotDePasse = request.getParameter("confirmation");
		
		if (motDePasse.equals(confirmationMotDePasse)) {
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			utilisateurDao.insert(utilisateur);
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
			System.out.println("insertion réussi");
		}
		else {
			System.out.println("erreur lors de l'insertion");
			doGet(request, response);
		}	
		
		
	}

}
