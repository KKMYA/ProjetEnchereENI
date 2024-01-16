package fr.eni.enchere.projet.bo;

import java.time.LocalDate;

public class Categorie extends ArticleEnVente {

	private int noCategorie;
	private String libelle;
	
	public Categorie() {
	}

	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	

	public Categorie(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int noCategorie,
			String libelle) {
		super(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente);
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", getNoArticle()=" + getNoArticle()
				+ ", getNomArticle()=" + getNomArticle() + ", getDescription()=" + getDescription()
				+ ", getDateDebutEncheres()=" + getDateDebutEncheres() + ", getDateFinEncheres()="
				+ getDateFinEncheres() + ", getMiseAPrix()=" + getMiseAPrix() + ", getPrixVente()=" + getPrixVente()
				+ ", getEtatVente()=" + getEtatVente() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
