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

		        Utilisateur utilisateur = new Utilisateur();
		        utilisateur.setNoUtilisateur(noUtilisateur);
		        System.out.println(noUtilisateur);
		        utilisateur.setPseudo(pseudoParam);
		        System.out.println(pseudoParam);
		        utilisateurdao.updatePseudo(utilisateur);
		    }
		    if (session != null && session.getAttribute("noUtilisateur") != null && inputNom) {
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setNom(nomParam);
		    	utilisateurdao.updateNom(utilisateur);
		    }
		    if (session!=null && session.getAttribute("noUtilisateur") != null && inputPrenom ) {
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setPrenom(prenomParam);
		    	utilisateurdao.updatePrenom(utilisateur);
		    }
		    if(session != null && session.getAttribute("noUtilisateur") != null && inputEmail){
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setEmail(emailParam);
		    	utilisateurdao.updateEmail(utilisateur);
		    }
		    if(session != null && session.getAttribute("noUtilisateur") != null && inputTelephone) {
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setTelephone(telephoneParam);
		    	utilisateurdao.updateTelephone(utilisateur);
		    }
		    if (session != null && session.getAttribute("noUtilisateur") != null && inputRue) {
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setRue(rueParam);
		    	utilisateurdao.updateRue(utilisateur);
		    }
		    if (session != null && session.getAttribute("noUtilisateur") != null && inputCodePostal) {
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setCodePostal(codePostalParam);
		    	utilisateurdao.updateCodePostal(utilisateur);
		    }
		    if (session != null && session.getAttribute("noUtilisateur") != null && inputVille) {
		    	int noUtilisateur = SessionID.noUtilisateurSession(request);
		    	
		    	Utilisateur utilisateur = new Utilisateur();
		    	utilisateur.setNoUtilisateur(noUtilisateur);
		    	utilisateur.setVille(villeParam);
		    	utilisateurdao.updateVille(utilisateur);
		    }
		        doGet(request, response);
		}

	}

