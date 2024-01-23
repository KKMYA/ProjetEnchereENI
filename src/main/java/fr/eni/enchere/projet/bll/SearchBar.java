package fr.eni.enchere.projet.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.dal.ConnectionProvider;

public class SearchBar {

	private static String QUERY_RECHERCHE = "SELECT * FROM ARTICLES_VENDUS WHERE nomArticle LIKE ?";
	
	
	public static List<ArticleEnVente> afficherArticlesRecherches(String recherche){
		List<ArticleEnVente> listeArticlesRecherches = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getConnection();	
				
				PreparedStatement stmt = con.prepareStatement(QUERY_RECHERCHE))
			{
				stmt.setString(1, recherche);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					ArticleEnVente article = new ArticleEnVente();
					
					article.setNomArticle(rs.getString(1));
					article.setDescription(rs.getString(2));
					article.setDateDebutEncheres(rs.getDate(3).toLocalDate());
					article.setDateFinEncheres(rs.getDate(4).toLocalDate());
					article.setMiseAPrix(rs.getInt(5));
					article.setPrixVente(rs.getInt(6));
					article.setNoUtilisateur(rs.getInt(7));
					article.setNoCategorie(rs.getInt(8));
					
					
					listeArticlesRecherches.add(article);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		
		return listeArticlesRecherches;
		
	}
}
