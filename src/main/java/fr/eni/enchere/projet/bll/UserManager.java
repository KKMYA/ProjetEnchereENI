package fr.eni.enchere.projet.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.ConnectionProvider;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;

public class UserManager {
	private static UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();
	private static ArticleEnVenteDAO articleDao =DAOFactory.GetArticleDAO();
	private static final String CHECK_ADMIN = "SELECT administrateur FROM UTILISATEURS WHERE no_utilisateur=?";


	public static  Utilisateur identificationPseudo(int idSession) {
		
	try {
		Utilisateur utilisateur = utilisateurDao.select(idSession);
		return utilisateur;
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
	}
	
	public static void supprimerUtilisateur(int idSession) {
		
		utilisateurDao.delete(idSession);
	}
	
	public static boolean checkAdmin (int noUtilisateur) {
	boolean checkAdmin = false;
		try(Connection con = ConnectionProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(CHECK_ADMIN);){
			pstmt.setInt(1, noUtilisateur);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int valeurAdmin = rs.getInt("administrateur");
				
				if(valeurAdmin == 1) {

					checkAdmin = true;
				}else {

					checkAdmin = false;
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return checkAdmin;
	}
}
