package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.dal.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class ServletDetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticle();
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noArticle = Integer.parseInt(request.getParameter("id_article"));
		ArticleEnVente articleDemande = articleDAO.afficherArticleSelonIdArticle(noArticle);
		request.setAttribute("ArticleSelonNoArticle", articleDemande);
		request.getRequestDispatcher("/WEB-INF/Accueil");
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
