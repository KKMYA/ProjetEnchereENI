package fr.eni.enchere.projet.bll;

import java.sql.SQLException;
import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;

public class UserManager {
	private static UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();
	private static ArticleEnVenteDAO articleDao =DAOFactory.GetArticleDAO();
	


	public static  Utilisateur identificationPseudo(int idSession) {
		
	try {
		Utilisateur utilisateur =	utilisateurDao.select(idSession);
		return utilisateur;
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
	}
	
	public static void supprimerUtilisateur(int idSession) {
		
		utilisateurDao.delete(idSession);
	}
	

}
