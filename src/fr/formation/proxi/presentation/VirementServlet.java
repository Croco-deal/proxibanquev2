package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.AccountService;

public class VirementServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		AccountService service = AccountService.getInstance();
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/virement.jsp")
		.forward(req, resp);
		String id = req.getParameter("id");
		String montant = req.getParameter("amount");
		
		Float amount = Float.parseFloat(montant);
		Integer id_client = Integer.parseInt(id);
		
		service.transfer();

	}
}
