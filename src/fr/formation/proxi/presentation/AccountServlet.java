package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.ClientService;

public class AccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		AccountService service = AccountService.getInstance();
		String id = req.getParameter("id");
		 Integer id_client = Integer.parseInt(id);
		
		req.setAttribute("accounts", service.getAll(id_client));
		
		System.out.println("");
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/comptes.jsp")
		.forward(req, resp);
	}

}