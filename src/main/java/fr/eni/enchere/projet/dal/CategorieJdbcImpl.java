package fr.eni.enchere.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.bo.Categorie;

public class CategorieJdbcImpl implements CategorieDAO{

	private static final String INSERT_CATEGORIE = "INSERT INTO CATEGORIES(libelle) VALUES (?)";
	private static final String DELETE_CATEGORIE = "DELETE FROM CATEGORIES WHERE no_categorie=?";
	private static final String UPDATE_CATEGORIE_NOM = "UPDATE CATEGORIES SET libelle=? WHERE no_categorie=?";
	private static final String SELECT_CATEGORIE = "SELECT * FROM CATEGORIES";
	private static final String SELECT_ID_CATEGORIE = "SELECT no_categorie FROM CATEGORIES where libelle=?";
	private static final String SELECT_LIBELLE_CATEGORIE = "SELECT libelle FROM CATEGORIES where no_categorie=?";
	
	
	
	@Override
	public int ajouterCategorie(Categorie categorie) {
		
		int key = -1;
		
		try(Connection con = ConnectionProvider.getConnection();					
		PreparedStatement stmt = con.prepareStatement(INSERT_CATEGORIE, Statement.RETURN_GENERATED_KEYS);)
		{
			stmt.setString(1, "libelle");
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
	public void supprimerCategorie(int noCategorie) {
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_CATEGORIE);)
			{
				stmt.setInt(1, noCategorie);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	@Override
	public void modifierCategorie(Categorie categorie, int noCategorie) {
		
		try(Connection con = ConnectionProvider.getConnection();
				
				PreparedStatement stmt = con.prepareStatement(UPDATE_CATEGORIE_NOM);)
			{
			stmt.setInt(2, categorie.getNoCategorie());
			stmt.setString(1, categorie.getNomArticle());
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
	
	
	@Override
	public List<Categorie> afficherCategories() {
		
		List<Categorie> toutesLesCategories = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE);)
			{
			
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					
					Categorie categorie = new Categorie();
					
					categorie.setLibelle(rs.getString("libelle"));
					categorie.setNoCategorie(rs.getInt("no_categorie"));
					
					
					toutesLesCategories.add(categorie);
				}				
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return toutesLesCategories;
	}


	@Override
	public int quelleCategorie(String categorie) {
		
		int indexCategorie = -1;
		try(Connection con = ConnectionProvider.getConnection();
				
				PreparedStatement stmt = con.prepareStatement(SELECT_ID_CATEGORIE);)
			{
			stmt.setString(2, categorie);		
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
			indexCategorie = rs.getInt(1);
			}
			
		
			} catch (SQLException e) {
				e.printStackTrace();
			}

	
		return indexCategorie;
	}
	@Override
	public String getNomCategorie(int noCategorie) {
		
		String categorie = null;
		try(Connection con = ConnectionProvider.getConnection();
				
				PreparedStatement stmt = con.prepareStatement(SELECT_LIBELLE_CATEGORIE);)
			{
			
			stmt.setInt(1, noCategorie);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
			categorie = rs.getString(2);
			}
		
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return categorie;
	}
}
	
	
	

