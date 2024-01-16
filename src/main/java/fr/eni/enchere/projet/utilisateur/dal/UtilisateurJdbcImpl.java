package fr.eni.enchere.projet.utilisateur.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.ConnectionProvider;

public class UtilisateurJdbcImpl implements UtilisateurDAO {

	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)  ";
	private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur=? ";
	private static final String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE  no_utilisateur=?";
	private static final String UPDATE_PSEUDO_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ? WHERE no_utilisateur = ?";
	private static final String UPDATE_NOM_UTILISATEUR = "UPDATE UTILISATEURS SET nom = ? WHERE no_utilisateur = ?";
	private static final String UPDATE_PRENOM_UTILISATEUR ="UPDATE UTILISATEURS SET prenom = ? WHERE no_utilisateur = ?" ;
	private static final String UPDATE_EMAIL_UTILISATEUR = "UPDATE UTILISATEURS SET email = ? WHERE no_utilisateur = ?";
	private static final String UPDATE_TELEPHONE_UTILISATEUR = "UPDATE UTILISATEURS SET telephone = ? WHERE no_utilisateur = ?";
	private static final String UPDATE_RUE_UTILISATEUR = "UPDATE UTILISATEURS SET rue = ? WHERE no_utilisateur = ?";
	private static final String UPDATE_CODEPOSTAL_UTILISATEUR = "UPDATE UTILISATEURS SET code_postal = ? WHERE no_utilisateur = ?" ;
	private static final String UPDATE_VILLE_UTILISATEUR ="UPDATE UTILISATEURS SET ville = ? WHERE no_utilisateur = ?";
	private static final String UPDATE_MOTDEPASSE_UTILISATEUR = "UPDATE UTILISATEURS SET mot_de_passe = ? WHERE no_utilisateur = ?";

	@Override
	public void insert(Utilisateur utilisateur) {
		
		try(Connection con =ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_UTILISATEUR,Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, "pseudo");
			stmt.setString(2, "nom");
			stmt.setString(3, "prenom");
			stmt.setString(4, "email");
			stmt.setString(5, "telephone");
			stmt.setString(6, "rue");
			stmt.setString(7, "code_postal");
			stmt.setString(8, "ville");
			stmt.setString(9, "mot_de_passe");
			stmt.setInt(10, 0);
			stmt.setBoolean(11, false);
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void updatePseudo(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_PSEUDO_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getPseudo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateNom(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_NOM_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getNom());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updatePrenom(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_PRENOM_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getPrenom());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateEmail(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_EMAIL_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateTelephone(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_TELEPHONE_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getTelephone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateRue(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_RUE_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getRue());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateCodePostal(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_CODEPOSTAL_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getCodePostal());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateVille(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_VILLE_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getVille());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateMotDePasse(Utilisateur utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(UPDATE_MOTDEPASSE_UTILISATEUR);) {
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			stmt.setString(1, utilisateur.getMotDePasse());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(int no_utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(DELETE_UTILISATEUR);) {
			stmt.setInt(1, no_utilisateur);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur select(int no_utilisateur)throws SQLException {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(SELECT_UTILISATEUR);) {
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			Utilisateur utilisateur = new Utilisateur(
					no_utilisateur,
					rs.getString("pseudo"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("email"),
					rs.getString("telephone"),
					rs.getString("rue"),
					rs.getString("code_postal"),
					rs.getString("ville"),
					rs.getString("mot_de_passe"),
					rs.getInt("credit"),
					rs.getBoolean("administrateur")
					);
			return utilisateur;
		
		}
	}
}
