package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.dal.RetraitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DetailEnchere")
public class ServletDetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int noArticle = Integer.parseInt(request.getParameter("id_article"));
		ArticleEnVente articleDemande = articleDAO.afficherArticleSelonIdArticle(noArticle);
		Retrait retrait = retraitDAO.afficherRetrait(articleDemande);
		request.setAttribute("ArticleSelonNoArticle", articleDemande);
		request.setAttribute("LieuDeRetrait", retrait);
		request.getRequestDispatcher("/WEB-INF/Accueil");
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
