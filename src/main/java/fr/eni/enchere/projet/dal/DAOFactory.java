package fr.eni.enchere.projet.dal;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.article.dal.ArticleEnVenteJdbcImpl;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurJdbcImpl;

public interface DAOFactory {
	
	public static ArticleEnVenteDAO GetPersonne() {
		return new ArticleEnVenteJdbcImpl();
	}
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurJdbcImpl();
	}

}