package fr.eni.enchere.projet.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import fr.eni.enchere.projet.bll.SessionID;
import fr.eni.enchere.projet.bll.UserManager;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;

@WebServlet("/modificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UtilisateurDAO utilisateurdao = DAOFactory.getUtilisateurDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
	    if (session != null && session.getAttribute("noUtilisateur") != null) {
	    	int idSession =Integer.parseInt(session.getAttribute("noUtilisateur").toString());
	    	
	    	try {
				Utilisateur utilisateur = utilisateurdao.select(idSession);
				request.setAttribute("utilisateur", utilisateur);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	    	
	    	
	    }
		request.getRequestDispatcher("WEB-INF/ModificationProfil.jsp").forward(request, response);
	}


		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // Vérification si les paramètres de la requête sont présents
		    String pseudoParam = request.getParameter("pseudo");
		    String nomParam = request.getParameter("nom");
		    String prenomParam = request.getParameter("prenom");
		    String emailParam = request.getParameter("email");
		    String telephoneParam = request.getParameter("telephone");
		    String rueParam = request.getParameter("rue");
		    String codePostalParam = request.getParameter("code_postal");
		    String villeParam = request.getParameter("ville");

		    boolean inputPseudo = pseudoParam != null && !pseudoParam.isEmpty();
		    boolean inputNom = nomParam != null && !nomParam.isEmpty();
		    boolean inputPrenom = prenomParam != null && !prenomParam.isEmpty();
		    boolean inputEmail = emailParam != null && !emailParam.isEmpty();
		    boolean inputTelephone = telephoneParam != null && !telephoneParam.isEmpty();
		    boolean inputRue = rueParam != null && !rueParam.isEmpty();
		    boolean inputCodePostal = codePostalParam != null && !codePostalParam.isEmpty();
		    boolean inputVille = villeParam != null && !villeParam.isEmpty();

		    HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
		    if (session != null && session.getAttribute("noUtilisateur") != null && inputPseudo) {
		        int noUtilisateur = SessionID.noUtilisateurSession(request);

		        String newPseudo = request.getParameter("pseudo");
		        Utilisateur utilisateur = new Utilisateur();
		        utilisateur.setNoUtilisateur(noUtilisateur);
		        System.out.println(noUtilisateur);
		        utilisateur.setPseudo(newPseudo);
		        System.out.println(newPseudo);
		        utilisateurdao.updatePseudo(utilisateur);

		        

		        doGet(request, response);
		  
		}

	}
}
