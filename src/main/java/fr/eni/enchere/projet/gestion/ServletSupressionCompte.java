package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.List;

import fr.eni.enchere.projet.bll.ArticleManager;
import fr.eni.enchere.projet.bll.UserManager;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.dal.RetraitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/suppressionProfil")
public class ServletSupressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RetraitDAO retraitDao = DAOFactory.getRetraitDAO();   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
		
		 response.sendRedirect(request.getContextPath() + "/");
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
		if (session != null && session.getAttribute("noUtilisateur") != null) {
			int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());	
			
			ArticleManager.RecupererNoArticleDeLaListe(ArticleManager.selectionArticleParUtilisateur(idSession));
			//List<ArticleEnVente>listeArticle = ArticleManager.selectionArticleParUtilisateur(idSession);
			
				
			
			ArticleManager.supressionArticleParUtilisateur(idSession);
			UserManager.supprimerUtilisateur(idSession);
			
		doGet(request, response);
	}
	}
}
