package fr.eni.enchere.projet.dal;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.article.dal.ArticleEnVenteJdbcImpl;

public interface DAOFactory {
	
	
	
	
	public static ArticleEnVenteDAO GetPersonne() {
		return new ArticleEnVenteJdbcImpl();
	}

}

