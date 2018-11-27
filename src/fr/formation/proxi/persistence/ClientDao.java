package fr.formation.proxi.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.ClientService;

public class ClientDao implements Dao<Client> {

	private final MySqlConnection mySqlConn;
	private final ClientService cs;

	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
		this.cs = ClientService.getInstance();
	}

	/*
	 * La méthode readAll() permet de lire la liste des clients sur la BDD
	 * 
	 * @return result : la liste de tous les clients sur la BDD
	 * 
	 */
	@Override
	public List<Client> readAll() {

		List<Client> result = new ArrayList<>();

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				result.add(new Client(id, firstname, lastname, email, address));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * La méthode update permet de mettre à jour les information d'un client sur la
	 * BDD
	 * 
	 * @return renvoie le Client modifié
	 * 
	 * 
	 */
	@Override

	public Client update(Client entity) {

		try {

			Statement st = this.mySqlConn.getConn().createStatement();
			String query = String.format(SqlQueries.UPDATE_CLIENT, entity.getFirstname(), entity.getLastname(),
					entity.getEmail(), entity.getAddress(), entity.getId());
			
			st.execute(query);
		} 
		
		catch (SQLException e) 
		
		{
			e.printStackTrace();
		}
		
		return entity;
	
	}

	
	
	@Override
	public List<Client> readAccountAll(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * La méthode read permet de lire le client à partir de la BDD
	 * @return : renvoie le client
	 *  
	 */
	public Client read(Integer id) {

		Client client = new Client();

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ, id));
			rs.next();
			// Integer id = rs.getInt("id");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");
			String address = rs.getString("address");
			client.setId(id);
			client.setFirstname(firstname);
			client.setLastname(lastname);
			client.setEmail(email);
			client.setAddress(address);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return client;
	}

}
