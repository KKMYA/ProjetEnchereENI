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

@WebServlet(urlPatterns = "/FicheEnchere")
public class ServletFIcheEnchere extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
	private static UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	private static CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	private static RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int noArticle = Integer.parseInt(request.getParameter("id_article"));
		
		ArticleEnVente articleDemande = articleDAO.afficherArticleSelonIdArticle(noArticle);
		request.setAttribute("ArticleEnVente", articleDemande);
		
	//	Retrait retrait = retraitDAO.afficherRetrait(articleDemande);
	//	request.setAttribute("LieuDeRetrait", retrait);
		
		
		Utilisateur utilisateurDemande = null;
		try {
			utilisateurDemande = utilisateurDAO.select(articleDemande.getNoUtilisateur());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("PseudoUtilisateur", utilisateurDemande);
		
		String categorieDemande = categorieDAO.getNomCategorie(articleDemande.getNoCategorie());
		request.setAttribute("CategorieArticle", categorieDemande);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
