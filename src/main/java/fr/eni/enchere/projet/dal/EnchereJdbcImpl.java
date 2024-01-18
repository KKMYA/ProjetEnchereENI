package fr.eni.enchere.projet.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Enchere;
import fr.eni.enchere.projet.bo.Utilisateur;

public class EnchereJdbcImpl implements EnchereDAO {

	private static final String INSERT_ENCHERE ="INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) WHERE (?,?,?,?)";
	private static final String SELECT_ALL_ENCHERE = "SELECT*FROM ENCHERES";
	
	@Override
	public void insert(Utilisateur utilisateur,Enchere enchere,ArticleEnVente articleEnVente) {
		
		
		try (Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(INSERT_ENCHERE);){
			stmt.setInt(1, utilisateur.getNoUtilisateur());
			stmt.setInt(2, articleEnVente.getNoArticle());
			// Je convertis en DateTime
			stmt.setTimestamp(3, Timestamp.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontantEnchere());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Enchere> selectEnchere() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<Enchere> selectEnchere() {
		List<Enchere> listeEncheres = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE)) {
			
			
				while(rs.next()) {
					// Récupération de la colonne de type DATETIME 
					Timestamp timestamp = rs.getTimestamp("date_enchere");
					
					// Conversion en LocalDateTime (si nécessaire)
					LocalDateTime localDateTime = timestamp.toLocalDateTime();
					Enchere enchere= new Enchere(
							rs.getInt("no_utilisateur"),
							rs.getInt("no_article"),
							localDateTime,
							rs.getInt("montant_enchere")
							);
				}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}*/
	
	
}
