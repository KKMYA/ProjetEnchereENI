package fr.eni.enchere.projet.bll;

import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.ConnectionProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class RecuperationMDP extends HttpServlet {


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


    public static void ResetPass(String email, Integer randomKey) throws SQLException {
        if (CheckMail(email)) {
            if (RandomKeyValide(email, randomKey)) {
                Random random = new Random();
                String nouveauMDP = String.valueOf(random.nextInt(100000, 999999));

                try {
                    Connection con = ConnectionProvider.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("UPDATE UTILISATEURS SET mot_de_passe = ? WHERE email = ?");
                    {
                        pstmt.setString(1, nouveauMDP);
                        pstmt.setString(2, email);
                        pstmt.executeUpdate();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }

        }


    }

    public void setRandomKey(Integer randomKey, String email) {
        int getRandomKey = Utilisateur.generateRandomKey(email);
        if (getRandomKey > 999 && getRandomKey < 10000){
            try (Connection con = ConnectionProvider.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("UPDATE UTILISATEURS SET randomKey = ?  WHERE email = ? ")) {
                pstmt.setInt(1, getRandomKey);
                pstmt.setString(2, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();

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

