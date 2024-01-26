package fr.eni.enchere.projet.bo;

import fr.eni.enchere.projet.bll.RecuperationMDP;

import java.util.Random;

public class Utilisateur {

    private int noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private static String email;
    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private Integer credit = 0;
    private static Integer randomKey;
    private boolean administrateur = false;


    public Utilisateur() {

    }

    public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
                       String rue, String codePostal, String ville, String motDePasse, Integer credit, Integer randomKey, boolean administrateur) {
        super();
        this.noUtilisateur = noUtilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        Utilisateur.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        this.credit = credit;
        Utilisateur.randomKey = randomKey;
        this.administrateur = administrateur;
    }

    public int utilisateurEstAdmin(Utilisateur utilisateur) {
        if (utilisateur.isAdministrateur() == true) {
            return 1;
        } else return 0;

    }

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    @Override
    public String toString() {
        return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
                + prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
                + codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
                + ", administrateur=" + administrateur + ", randomKey=" + randomKey + "]";
    }


    public static Integer getRandomKey() {
        return randomKey;
    }


    //Méthode permettant de générer une clé de confirmation d'email attribuée à un utilisateur
    public static String generateRandomKey(String email) {
        int randomKey;
        if (RecuperationMDP.CheckMail(email)) {
            Random random = new Random();
            randomKey = random.nextInt(9999 - 1000) + 1000;
            return Integer.toString(randomKey);

        } else {
            return null;
        }
    }
}