package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bll.SearchBar;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Categorie;
import fr.eni.enchere.projet.dal.CategorieDAO;
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
	private static CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();

	private void loadImages(List<ArticleEnVente> articles) {
		
		articles.stream().forEach(article -> article.setImage(ArticleEnVente.IMAGE_BASE_NAME + article.getNoArticle() + ".jpeg"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	
		
		//if(request.getParameter("Rechercher") == null && request.getParameter("selectedCategory") == null )
		
		List<ArticleEnVente> listeDeTousLesArticles = articleDAO.afficherArticleEnVente();
		loadImages(listeDeTousLesArticles);
		List<Categorie> listeDeCategories = categorieDAO.afficherCategories();
		request.setAttribute("listeDeCategories", listeDeCategories);
		
		
		
		if(request.getParameter("Rechercher") != null){
			String recherche = request.getParameter("Rechercher").toString();			
			List<ArticleEnVente> listeArticlesRecherches = SearchBar.afficherArticlesRecherches(recherche);
			loadImages(listeArticlesRecherches);
			request.setAttribute("listeArticles", listeArticlesRecherches);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		}else if(request.getParameter("selectedCategory")!=null) {
			List<ArticleEnVente>listeArticlesParCategorie = new ArrayList<>();
			String categorie = request.getParameter("selectedCategory");
			int idCategorie = categorieDAO.quelleCategorie(categorie);
			listeArticlesParCategorie = articleDAO.afficherAticleEnVenteSelonCategorie(idCategorie);
			request.setAttribute("listeArticles", listeArticlesParCategorie);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			
		}else {
			request.setAttribute("listeArticles", listeDeTousLesArticles);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
