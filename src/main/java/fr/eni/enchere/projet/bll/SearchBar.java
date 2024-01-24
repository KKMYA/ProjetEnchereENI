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

	private static String QUERY_RECHERCHE = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE ?";
	
	
	public static List<ArticleEnVente> afficherArticlesRecherches(String recherche){
		List<ArticleEnVente> listeArticlesRecherches = new ArrayList<>();
		System.out.println(recherche);
		try(Connection con = ConnectionProvider.getConnection();	
				
				PreparedStatement stmt = con.prepareStatement(QUERY_RECHERCHE))
			{
				String search = "%";
				search += recherche;
				search += "%";
				stmt.setString(1, search);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					ArticleEnVente article = new ArticleEnVente();
					
					article.setNomArticle(rs.getString("nom_article"));
					article.setDescription(rs.getString("description"));
					article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
					article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
					
					article.setMiseAPrix(rs.getInt("prix_initial"));
					article.setPrixVente(rs.getInt("prix_vente"));
					article.setNoUtilisateur(rs.getInt("no_utilisateur"));
					article.setNoCategorie(rs.getInt("no_categorie"));
					
					
					listeArticlesRecherches.add(article);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return listeArticlesRecherches;
		
	}
}
