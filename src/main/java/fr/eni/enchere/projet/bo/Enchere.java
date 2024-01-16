package fr.eni.enchere.projet.bo;

import java.time.LocalDateTime;

public class Enchere extends Utilisateur{
	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	
	
	public Enchere() {
	
}


	public Enchere(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur,
			LocalDateTime dateEnchere, Integer montantEnchere) {
		super(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit,
				administrateur);
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public Enchere(LocalDateTime dateEnchere, Integer montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public Integer getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", getNoUtilisateur()="
				+ getNoUtilisateur() + ", getPseudo()=" + getPseudo() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getEmail()=" + getEmail() + ", getTelephone()=" + getTelephone() + ", getRue()="
				+ getRue() + ", getCodePostal()=" + getCodePostal() + ", getVille()=" + getVille()
				+ ", getMotDePasse()=" + getMotDePasse() + ", getCredit()=" + getCredit() + ", isAdministrateur()="
				+ isAdministrateur() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	


	
}
