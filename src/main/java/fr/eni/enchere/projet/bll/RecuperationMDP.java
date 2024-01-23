package fr.eni.enchere.projet.bll;

import fr.eni.enchere.projet.dal.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecuperationMDP {


    public static boolean CheckMail(String email) throws SQLException {

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

    public static String ResetPass(String email) throws SQLException {

        if (CheckMail(String email)) {
            try (Connection con = ConnectionProvider.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("SELECT email FROM UTILISATEURS WHERE email = ?")) {


                
            }catch(SQLException e){
                e.printStackTrace();
        }

        }

    }
}