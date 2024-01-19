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
		String categorie = request.getParameter("categorieChoix");
		String rueRetrait = request.getParameter("rueRetrait");
		String codePostalRetrait = request.getParameter("code_postal");
		String villeRetrait = request.getParameter("villeRetrait");
		
		int prixInitial = Integer.parseInt(request.getParameter("prix_initial_de_vente"));
		
		ArticleEnVente article = new ArticleEnVente();
		Retrait retrait = new Retrait();
		
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setPrixVente(prixInitial);
		
		retrait.setRue(rueRetrait);
		retrait.setCodePostal(codePostalRetrait);
		retrait.setVille(villeRetrait);		
		
		int noArticle = -1;
		
		try {
			noArticle = articleDAO.ajouterArticle(article);
	
		} catch (Exception e) {
			response.sendError(1, "ERREUR DAL");
			return;
		}
		
		retrait.setNoArticle(noArticle);
		int categorieIndex = categorieDAO.quelleCategorie(categorie);

		article.setNoCategorie(categorieIndex);
		

		retraitDAO.ajouterRetrait(retrait);
				
		doGet(request, response);

	}

}
