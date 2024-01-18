package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;
import fr.eni.enchere.projet.dal.CategorieDAO;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.dal.RetraitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/AjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
	private static CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	private static RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Vendre").forward(request, response);

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomArticle = request.getParameter("nom_article");
		String description = request.getParameter("description_article");
		int prixInitial = Integer.parseInt(request.getParameter("prix_initial_de_vente"));
		String categorie = request.getParameter("categorieChoix");
		
		ArticleEnVente	article = new ArticleEnVente();
		Retrait retrait = new Retrait();
		
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setPrixVente(prixInitial);
		
		int noArticle = articleDAO.ajouterArticle(article);
		
		if(nomArticle !=null && description !=null && prixInitial>=0) {
		articleDAO.ajouterArticle(article);
		}else {
		doGet(request, response);
		}
		
		retrait.setNoArticle(noArticle);
				
		
	}

}
