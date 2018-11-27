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
		String id = req.getParameter("id");
		Integer id_client = Integer.parseInt(id);
		req.setAttribute("accounts", service.getAll(id_client));
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/virement.jsp")
		.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AccountService service = AccountService.getInstance();
		
		
		String id_emetteur = req.getParameter("id_emetteur");
		Integer id_emet = Integer.parseInt(id_emetteur);
		String id_receveur = req.getParameter("id_receveur");
		Integer id_recev = Integer.parseInt(id_receveur);
		String montant = req.getParameter("amount");
		Float amount = Float.parseFloat(montant);
		
		if(service.transfer(id_emet, id_recev, amount)){
			service.transfer(id_emet, id_recev, amount);
			resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
		}
		else {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/erreur.html");
		}	
	
		}
	}

