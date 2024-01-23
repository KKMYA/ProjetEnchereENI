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
	public int insert(Utilisateur utilisateur) {
		
		int key = -1;
		
		try(Connection con =ConnectionProvider.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_UTILISATEUR,Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setInt(11, utilisateur.utilisateurEstAdmin(utilisateur));
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
	public Utilisateur select(int no_utilisateur) {
		
		try(Connection con = ConnectionProvider.getConnection();PreparedStatement stmt = con.prepareStatement(SELECT_UTILISATEUR);) {
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			rs.next();
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
                    randomKey, rs.getBoolean("administrateur")
					);
			return utilisateur;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
