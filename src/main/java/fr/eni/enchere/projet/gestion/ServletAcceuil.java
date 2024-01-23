package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.List;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bll.SearchBar;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.dal.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(urlPatterns = "")
public class ServletAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<ArticleEnVente> listeDeTousLesArticles = articleDAO.afficherArticleEnVente();
		System.out.println(listeDeTousLesArticles);

		
		if(request.getAttribute("Rechercher") != null){
			String recherche = request.getAttribute("Rechercher").toString();
			List<ArticleEnVente> listeArticlesRecherches = SearchBar.afficherArticlesRecherches(recherche);
			request.setAttribute("listeArticles", listeArticlesRecherches);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

			
		}else {
//		List<ArticleEnVente> listeDeTousLesArticles = articleDAO.afficherArticleEnVente();
		request.setAttribute("listeArticles", listeDeTousLesArticles);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
