package fr.eni.enchere.projet.bo;

import java.time.LocalDateTime;

public class Enchere{
	private int noUtilisateur;
	private int  noArticleEnVente;
	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	
	public Enchere() {
	
}

	public Enchere(int noUtilisateur, int noArticleEnVente, LocalDateTime dateEnchere, Integer montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticleEnVente = noArticleEnVente;
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

	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	public int getNoArticleEnVente() {
		return noArticleEnVente;
	}
	
	public void setNoArticleEnVente(int noArticleEnVente) {
		this.noArticleEnVente = noArticleEnVente;
	}
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}


	
	
	


	
}
