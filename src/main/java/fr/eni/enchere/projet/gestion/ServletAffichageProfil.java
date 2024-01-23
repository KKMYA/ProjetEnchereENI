package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import fr.eni.enchere.projet.bll.IdentificationPseudo;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/affichageProfil")
public class ServletAffichageProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurDAO utilisateurdao = DAOFactory.getUtilisateurDAO();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
		
		if (session != null && session.getAttribute("noUtilisateur") != null) {
			int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());								
			Utilisateur utilisateur =	IdentificationPseudo.identification(idSession);
			request.setAttribute("utilisateur", utilisateur);			
			request.getRequestDispatcher("WEB-INF/affichageProfil.jsp").forward(request, response);;
			}
			else {
				System.out.println("Problème affichage");
			}			
			
		}
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	
	}
