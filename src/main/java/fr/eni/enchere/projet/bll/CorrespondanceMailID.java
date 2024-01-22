package fr.eni.enchere.projet.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.projet.dal.ConnectionProvider;

public class CorrespondanceMailID {

	public static int recuperationID(String email) {
		
		int noUtilisateur = -1;
		try(Connection con = ConnectionProvider.getConnection();	
				PreparedStatement stmt = con.prepareStatement("SELECT no_utilisateur FROM UTILISATEURS where email=?");)
			{
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				noUtilisateur = rs.getInt(1);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return noUtilisateur;
		
	}
}
