package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.ClientService;




/**
 * La classe AccounServlet gère l'affichage des clients 
 * 
 * @author Omar & Sarah
 * 
 *
 */
public class AccountServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appel de l'instance AccountService

		AccountService service = AccountService.getInstance();

		// Récupération de l'id du client de la jsp

		String id = req.getParameter("id");
		Integer id_client = Integer.parseInt(id);
		
		// stock la liste des clients dans la variable accounts
		// qu'on utilisera sur la jsp pour l'affichage

		req.setAttribute("accounts", service.getAll(id_client));

		// redirige après validation sur la page qui affiche les comptes.
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/comptes.jsp").forward(req, resp);
	}

}