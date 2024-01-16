package fr.eni.enchere.projet.bo;

import java.time.LocalDateTime;

public class Enchere{
	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	
	
	public Enchere() {
	
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
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}


	
	
	


	
}
