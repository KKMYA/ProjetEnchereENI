package fr.eni.enchere.projet.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.projet.dal.ConnectionProvider;

public class Login {

	public static boolean validationConnexion(String email, String motDePasse) {
		
		boolean validation = false;
		
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM UTILISATEURS WHERE email=? and mot_de_passe=?");) {
			
			stmt.setString(1, email);
			stmt.setString(2, motDePasse);
			
			ResultSet rs = stmt.executeQuery();
			validation = rs.next();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return validation;
	}
}
	
	