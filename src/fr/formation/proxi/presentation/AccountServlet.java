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
		System.out.println("avant");
		req.setAttribute("accounts", service.getAll());
		System.out.println("apres");
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/comptes.jsp")
		.forward(req, resp);
	}

}