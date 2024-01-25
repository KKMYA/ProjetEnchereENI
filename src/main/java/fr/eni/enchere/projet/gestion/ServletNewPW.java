package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.enchere.projet.bll.CorrespondanceMailID;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/setNewPW")
public class ServletNewPW extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO(); 
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/forgottenPWnewPW.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = (String) request.getSession().getAttribute("email");
		
		
		if (request.getParameter("EntrerMDP") != null && request.getParameter("ConfirmMDP") != null) {
            String errorPassword = "Les mots de passe ne correspondent pas";
            String nouveauMotDePasse = request.getParameter("EntrerMDP").toString();
            String confirmationnouveauMotDePasse = request.getParameter("ConfirmMDP").toString();
            if (nouveauMotDePasse.equals(confirmationnouveauMotDePasse)) {
                int idUser = CorrespondanceMailID.recuperationID(email);
                try {
                    Utilisateur user = utilisateurDAO.select(idUser);
                    user.setMotDePasse(confirmationnouveauMotDePasse);
                    utilisateurDAO.updateMotDePasse(user);
                } catch (SQLException e) {
                    request.setAttribute("error", errorPassword);
                    e.printStackTrace();
                }
            }

        } else {
    		response.sendRedirect(request.getContextPath()+ "/");

        }
		response.sendRedirect(request.getContextPath()+ "/");

	}

}
