package fr.eni.enchere.projet.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.enchere.projet.bll.RecuperationMDP;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet(urlPatterns = "/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();   
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
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
		String errorMotDePasse = null;
		String errorUnicityMailPseudo = null;

		if(RecuperationMDP.CheckMail(email)==false && utilisateurDao.checkPseudo(pseudo)==false) {
			if (motDePasse.equals(confirmationMotDePasse)) {
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(codePostal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(motDePasse);
				utilisateurDao.insert(utilisateur);

				response.sendRedirect(request.getContextPath() + "/connexion");
				System.out.println("insertion réussie");
			}
			else {
				System.out.println("erreur lors de l'insertion");
				errorMotDePasse = "Les mots de passe ne correspondent pas!";
				request.setAttribute("errorMotDePasse", errorMotDePasse);
				System.out.println(errorMotDePasse);
				request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
			}
		}else {
				errorUnicityMailPseudo = "Le mail et/ou le pseudo n'est pas disponible!";
				request.setAttribute("errorMailPseudo", errorUnicityMailPseudo);
				request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);

			}
		
	}

}
