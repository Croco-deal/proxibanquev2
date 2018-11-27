package fr.formation.proxi.metier.entity;

import java.util.List;

import fr.formation.proxi.persistence.ClientDao;

public class ClientService {



	private static final ClientService INSTANCE = new ClientService();
	public static ClientService getInstance() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}

	private final ClientDao dao;
	
	public ClientService() {
		this.dao = new ClientDao();
			
	}
	
	
	/**
	 * 
	 * 
	 * @return liste d'objets de la classe Client
	 */
	public List<Client> getAll(){
		return this.dao.readAll();
	}
	
	/**
	 * @param id  : l'id du Client
	 * @param firstname : le prénom du client
	 * @param lastname : le nom du client
	 * @param email : l'email du client
	 * @param address : l'adresse du client
	 * @return updatedClient :  Instance de la classe Client
	 */
	public Client getUpdate(Integer id ,String firstname, String lastname , String email , String address ) {
		Client updatedClient = new Client(id,firstname,lastname,email,address);


		return this.dao.update(updatedClient);
		
	}
	
	
	
	/**
	 * cette méthode retourne la méthode read 
	 * de la classe ArticleDao
	 * @param id : id du client 
	 * @return de type Client : 
	 */
	public Client read(Integer id) {
		return this.dao.read(id);
	}
	
}
