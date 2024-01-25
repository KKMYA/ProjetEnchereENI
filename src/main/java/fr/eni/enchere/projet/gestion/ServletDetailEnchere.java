package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Categorie;
import fr.eni.enchere.projet.bo.Retrait;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.CategorieDAO;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.dal.RetraitDAO;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/DetailEnchere")
public class ServletDetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
	private static CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	private static UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		int noArticle = Integer.parseInt(request.getParameter("articleId").toString());
		
		ArticleEnVente article = articleDAO.afficherArticleSelonIdArticle(noArticle);	
		Retrait retrait = retraitDAO.afficherRetrait(noArticle);
		int userId = article.getNoUtilisateur();
		try {
			Utilisateur user = utilisateurDAO.select(userId);
			request.setAttribute("utilisateur", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(article);
		
		Categorie categorie = new Categorie();

		String libelleCategorie = categorieDAO.getNomCategorie(article.getNoCategorie());
		categorie.setLibelle(libelleCategorie);
		System.out.println(categorie);
		
		request.setAttribute("retrait", retrait);
		request.setAttribute("article", article);
		request.setAttribute("categorie", categorie);
		request.getRequestDispatcher("WEB-INF/FicheEnchere.jsp").forward(request, response);

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		request.getParameter("articleId");
		int noArticle = Integer.parseInt(request.getParameter("articleId").toString());
		request.getRequestDispatcher("WEB-INF/FicheEnchere.jsp").forward(request, response);

		doGet(request, response);
	}

}
