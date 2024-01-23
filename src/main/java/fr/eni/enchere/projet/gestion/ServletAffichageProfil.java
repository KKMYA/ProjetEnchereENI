package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.List;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bll.IdentificationPseudo;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	@WebServlet("/affichageProfil")
	public class ServletAffichageProfil extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		ArticleEnVenteDAO articledao = DAOFactory.GetArticleDAO();
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
			if (session != null && session.getAttribute("noUtilisateur") != null) {
				int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());	
				System.out.println(idSession);
				Utilisateur utilisateur =	IdentificationPseudo.identification(idSession);
				System.out.println(utilisateur);
				request.setAttribute("utilisateur", utilisateur);
				List<ArticleEnVente>listeArticle = articledao.afficherArticleSelonIdVendeur(idSession);
				request.setAttribute("listeArticles", listeArticle);
				System.out.println(listeArticle);
				request.getRequestDispatcher("WEB-INF/affichageProfil.jsp").forward(request, response);
			}
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
