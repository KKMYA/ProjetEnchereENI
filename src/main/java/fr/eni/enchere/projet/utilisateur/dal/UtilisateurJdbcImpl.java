package fr.eni.enchere.projet.utilisateur.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.ConnectionProvider;

public class UtilisateurJdbcImpl implements UtilisateurDAO {

	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)  ";

	@Override
	public void insert(Utilisateur utilisateur) {
		
		try(Connection con =ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_UTILISATEUR);) {
			stmt.setString(1, "no_utilisateur");
			stmt.setString(2, "pseudo");
			stmt.setString(3, "nom");
			stmt.setString(4, "prenom");
			stmt.setString(5, "email");
			stmt.setString(6, "telephone");
			stmt.setString(7, "rue");
			stmt.setString(8, "code_postal");
			stmt.setString(9, "ville");
			stmt.setString(10, "mot_de_passe");
			stmt.setInt(11, 0);
			stmt.setBoolean(12, false);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void update(int id) {
		
		
	}


	@Override
	public void delete(int id) {
		
	}

	@Override
	public Utilisateur select(int id) {
	
		return null;
	}

}
