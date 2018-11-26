package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.ClientService;

public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ClientService service = ClientService.getInstance();
		req.setAttribute("clients", service.getAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp")
		.forward(req, resp);
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String idClient = req.getParameter("id");
			Integer id = Integer.parseInt(idClient);
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			ClientService service = ClientService.getInstance();
			service.update(firstname, lastname, email, address);
			resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");

}
}
