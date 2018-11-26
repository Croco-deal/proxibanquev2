package fr.formation.proxi.metier.entity;

import fr.formation.proxi.persistence.ClientDao;

public class ClientService {

	public Object getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private static final ClientService INSTANCE = new ClientService();
	public static ClientService getInstance() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}


	private final ClientDao dao;
	
	public ClientService() {
		this.dao = new ClientDao();
			
	}
}
