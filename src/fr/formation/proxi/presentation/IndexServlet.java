package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.ClientService;


public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// Appel de notre instance unique de la classe ClientService (Singleton)
		ClientService service = ClientService.getInstance();
		// Chargement de la liste d'article en attribut de requête
		req.setAttribute("articles", service.getAll());
		//Chargement de l’article en attribut de requête; 
		//req.setAttribute("article", service.get
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp")
		.forward(req, resp);

}
