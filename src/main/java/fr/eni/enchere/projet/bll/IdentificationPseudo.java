package fr.eni.enchere.projet.bll;

import java.sql.SQLException;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;

public class IdentificationPseudo {
	private static UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();
	
	


	public static  Utilisateur identification(int idSession) {
		
	try {
		Utilisateur utilisateur =	utilisateurDao.select(idSession);
		return utilisateur;
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
	}
	
}
