package fr.eni.enchere.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;

public class RetraitJdbcImpl implements RetraitDAO {
	
	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS(rue, code_postal, ville) VALUES (?,?,?)";
	private static final String DELETE_RETRAIT = "DELETE FROM RETRAITS WHERE no_article=?";
	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue=?, code_postal=?, ville=? WHERE no_article=?";
	private static final String SELECT_RETRAIT_ID = "SELECT RETRAITS FROM CATEGORIES WHERE no_artcle =?";
	
	
	@Override
	public void ajouterRetrait(Retrait retrait) {
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement stmt = con.prepareStatement(INSERT_RETRAIT);) 
				{
			
			stmt.setString(1, "rue");
			stmt.setString(2, "code_postal");
			stmt.setString(3, "ville");
			stmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifierRetrait(Retrait retrait, ArticleEnVente article) {
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement stmt = con.prepareStatement(UPDATE_RETRAIT);) 
				{
			
			stmt.setInt(4, article.getNoArticle());
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			stmt.executeUpdate();
								
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void deleteRetrait(ArticleEnVente article) {
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement stmt = con.prepareStatement(DELETE_RETRAIT);) 
				{
				stmt.setInt(1, article.getNoArticle());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public Retrait afficherRetrait(ArticleEnVente article) {
		Retrait retraitPourArticle = new Retrait();
		
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_RETRAIT_ID);) 
				{
				stmt.setInt(1, article.getNoArticle());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					Retrait retrait = new Retrait();
					
					retrait.setRue(rs.getString("rue"));
					retrait.setCodePostal(rs.getString("code_postal"));
					retrait.setVille(rs.getString("ville"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return retraitPourArticle;
	}



}
