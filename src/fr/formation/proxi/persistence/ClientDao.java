package fr.formation.proxi.persistence;

import java.util.List;

import fr.formation.proxi.metier.entity.Client;

public class ClientDao implements Dao<Client> {

private final MySqlConnection mySqlConn;
	
	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}
		

	@Override
	public Client update(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


	}

	





