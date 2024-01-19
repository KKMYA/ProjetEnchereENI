package fr.eni.enchere.projet.bll;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionID {

	public static int noUtilisateurSession(HttpServletRequest request){
		
	    HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
	    if (session != null && session.getAttribute("noUtilisateur") != null) {
	        return (int) session.getAttribute("noUtilisateur");
	        
	    } else {
	        // Gérer le cas où la session n'existe pas ou ne contient pas l'ID
	        return -1; // Ou toute autre logique appropriée
		
	    }

	}
}

