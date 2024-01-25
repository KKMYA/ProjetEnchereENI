package fr.eni.enchere.projet.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.dal.DAOFactory;

public class ArticleManager {
	
	private static ArticleEnVenteDAO articleDao =DAOFactory.GetArticleDAO();
	
	//je crée une methode qui selectionne la liste d'artcile mise en vente par l'utilisateur connecté
	
	public static List<ArticleEnVente> selectionArticleParUtilisateur(int idSession){
		
		List<ArticleEnVente>listeArticleDAO=articleDao.afficherArticleSelonIdVendeur(idSession);
		return listeArticleDAO;
		
	}
	


	public static void supressionArticleParUtilisateur(int idSession) {
		
		articleDao.supprimerArticleParUtilisateur(idSession);
	}
	
	
}
