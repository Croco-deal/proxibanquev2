package fr.formation.proxi.presentation;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.ClientService;




/**
 * met à jour les informations du client
 * 
 * @author Omar  & Sarah
 *
 */
public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(id);
		req.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/editer.jsp")
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
		    Client client = new Client(id, firstname, lastname, email, address);
			// service.getUpdate(client);
			req.setAttribute("client", client);
		    service.getUpdate(id, firstname, lastname, email, address);
			// System.out.println(id+firstname+lastname+email+address);
			
			
			resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");

}
}
