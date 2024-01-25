package fr.eni.enchere.projet.bll;


import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.ConnectionProvider;
import jakarta.servlet.http.HttpServlet;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.ConnectionProvider;
import jakarta.servlet.http.HttpServlet;


public class RecuperationMDP extends HttpServlet {

	private static final long serialVersionUID = 1L;

    //Permet de vérifier si l'adresse mail correspond à une entrée en BDD
	public static boolean CheckMail(String email) {

        boolean check = false;

        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT email FROM UTILISATEURS WHERE email = ?")) {

            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                //check = true;
                check = rs.next();

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return check;
    }



    //Méthode permettant d'affecter une random key à un utilisateur en BDD
    public void setRandomKey(Integer randomKey, String email) {
        int getRandomKey = Integer.parseInt((Utilisateur.generateRandomKey(email)));
        if (getRandomKey > 999 && getRandomKey < 10000){
            try (Connection con = ConnectionProvider.getConnection()) {
                assert con != null;
                try (PreparedStatement pstmt = con.prepareStatement("UPDATE UTILISATEURS SET randomKey = ?  WHERE email = ? ")) {
                    pstmt.setString(1, (Integer.toString(getRandomKey)));
                    pstmt.setString(2, email);
                    pstmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }


     // Permet de vérifier si la random key entrée par l'utilisateur correspond à la random key présente à l'index de son compte en BDD
    private static boolean RandomKeyValide(String email, Integer randomKey) {
        if (CheckMail(email))
            try (Connection con = ConnectionProvider.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("SELECT random_key FROM UTILISATEURS WHERE email = ?")) {
                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Integer randomKeyStockee = rs.getInt("randomKey");
                    return randomKey.equals(randomKeyStockee);

                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        return false;

    }

    //Méthode crééant un nouveau MDP stocké en BDD pour l'utilisateur choisi
    public static void ResetPass(String email, Integer randomKey) throws SQLException {
        if (CheckMail(email)) {
            if (RandomKeyValide(email, randomKey)) {
                Random ran = new Random();
                int nouveauMDP = ran.nextInt( 999999-100000)+100000;

                try {
                    Connection con = ConnectionProvider.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("UPDATE UTILISATEURS SET mot_de_passe = ? WHERE email = ?");
                    {
                        pstmt.setInt(1, nouveauMDP);
                        pstmt.setString(2, email);
                        pstmt.executeUpdate();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }

        }


    }



}
  /*  private static void updateMDP(String email, String nouveauMDP){
        if (CheckMail(email)) {
            if (RandomKeyValide(email)) {
        Random random = new Random();
        nouveauMDP = String.valueOf(random.nextInt(100000, 999999));

        try {Connection con = ConnectionProvider.getConnection();
            PreparedStatement pstmt = con.prepareStatement("UPDATE UTILISATEURS SET mot_de_passe = ? WHERE email = ?")){
            pstmt.setString(1, nouveauMDP);
            pstmt.setString(2,email);
            pstmt.executeUpdate();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


    }*/


