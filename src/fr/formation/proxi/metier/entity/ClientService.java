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
	public List<Client> getAll(){
		return this.dao.readAll();
	}
	
	public Client getUpdate() {
		Client updatedClient = new Client();
		return this.dao.update(updatedClient);
		
	}
	
}
