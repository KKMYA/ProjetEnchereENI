package fr.eni.enchere.projet.article.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.dal.ConnectionProvider;

public class ArticleEnVenteJdbcImpl implements ArticleEnVenteDAO {

	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente,"
			+ "no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String UPDATE_ARTICLE_NOM_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article = ? WHERE no_article = ?";
	private static final String UPDATE_ARTICLE_DESCRIPTION = "UPDATE ARTICLES_VENDUS SET description = ? WHERE no_article = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String SELECT_BY_ID_VENDEUR = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur = ?";
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String DELETE_ARTICLE_BY_UTILISATEUR = "DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur=?";

	
	@Override
	public int ajouterArticle(ArticleEnVente articleEnVente, int noUtilisateur){
		
		int key = -1;
		
		LocalDate aujourdhui = LocalDate.now();
		LocalDate quinzeJours = aujourdhui.plusDays(15);
		
		
		try(Connection con = ConnectionProvider.getConnection();	
				
			PreparedStatement stmt = con.prepareStatement(INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);)
		{
			stmt.setString(1,articleEnVente.getNomArticle());
			stmt.setString(2, articleEnVente.getDescription());
			stmt.setDate(3, Date.valueOf(LocalDate.now()));
			stmt.setDate(4, Date.valueOf(LocalDate.now()));
			stmt.setInt(5, articleEnVente.getMiseAPrix());
			stmt.setInt(6, 0);
			stmt.setInt(7, noUtilisateur);
			stmt.setInt(8, articleEnVente.getNoCategorie());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
			key = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
		
	}

	@Override
	public void supprimerArticle(int noArticle) {
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_ARTICLE);)
			{
			stmt.setInt(1, noArticle);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	@Override
	public void supprimerArticleParUtilisateur(int noUtilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_ARTICLE_BY_UTILISATEUR);)
			{
			stmt.setInt(1, noUtilisateur);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void modifierNomArticle(ArticleEnVente articleEnVente) {
		
		try(Connection con = ConnectionProvider.getConnection();
				
				PreparedStatement stmt = con.prepareStatement(UPDATE_ARTICLE_NOM_ARTICLE);)
			{
			stmt.setInt(2, articleEnVente.getNoArticle());
			stmt.setString(1, articleEnVente.getNomArticle());
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
	
	@Override
	public void modifierDescriptionArticle(ArticleEnVente articleEnVente) {
		
		try(Connection con = ConnectionProvider.getConnection();
				
			PreparedStatement stmt = con.prepareStatement(UPDATE_ARTICLE_DESCRIPTION);)
			{
			stmt.setInt(2, articleEnVente.getNoArticle());
			stmt.setString(1, articleEnVente.getDescription());
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	@Override
	public ArticleEnVente afficherArticleSelonIdArticle(int noArticle) {
		
		ArticleEnVente article = new ArticleEnVente();	
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);)
		{
			
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			article.setNoArticle(rs.getInt("no_article"));
			article.setNoCategorie(rs.getInt("no_categorie"));
			article.setNomArticle(rs.getString("nom_article"));
			article.setNoUtilisateur(rs.getInt("no_utilisateur"));
			article.setDescription(rs.getString("description"));
			article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
			article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
			article.setMiseAPrix(rs.getInt("prix_initial"));
			article.setPrixVente(rs.getInt("prix_vente"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return article; 
	}
	
	@Override
	public List<ArticleEnVente> afficherArticleEnVente() {
		
		List<ArticleEnVente> tousLesArticlesEnVente = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();)
			{ 
				while(rs.next()) {
					ArticleEnVente article = new ArticleEnVente();
					
					article.setNoArticle(rs.getInt("no_article"));
					article.setNomArticle(rs.getString("nom_article"));
					article.setDescription(rs.getString("description"));
					article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
					article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
					article.setMiseAPrix(rs.getInt("prix_initial"));
					article.setPrixVente(rs.getInt("prix_vente"));
					
					tousLesArticlesEnVente.add(article);
				}				
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return tousLesArticlesEnVente;
	}
	
	@Override
	public List<ArticleEnVente> afficherArticleSelonIdVendeur(int noUtilisateur) {
		
		List<ArticleEnVente> articleEnVente = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_VENDEUR);)
			{ 
				stmt.setInt(1, noUtilisateur);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					ArticleEnVente article = new ArticleEnVente();
					article.setNoUtilisateur(rs.getInt("no_utilisateur"));
					article.setNoArticle(rs.getInt("no_article"));
					article.setNomArticle(rs.getString("nom_article"));
					article.setDescription(rs.getString("description"));
					article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
					article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
					article.setMiseAPrix(rs.getInt("prix_initial"));
					article.setPrixVente(rs.getInt("prix_vente"));
					
					articleEnVente.add(article);
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return articleEnVente;
	}

}
