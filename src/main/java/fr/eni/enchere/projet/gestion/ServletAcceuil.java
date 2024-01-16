package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAcceuil
 */

@WebServlet("")
public class ServletAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAcceuil() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("TEST TEST TEST");
		response.getWriter().append("TEST TEST TEST");
		response.getWriter().append("TEST TEST TEST");
		response.getWriter().append("TEST TEST TEST");
		response.getWriter().append("TEST TEST TEST");
		response.getWriter().append("TEST TEST TEST");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
