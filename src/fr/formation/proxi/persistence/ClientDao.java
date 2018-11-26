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
		
	@Override
	public List<Client> readAll() {
		
		List<Client> result = new ArrayList<>();

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String firstname  = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				result.add(new Client(id, firstname , lastname , email , address));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	
	}
	
	@Override
	public Client update(Client entity) {
		
		
		try {
		
			Statement st = this.mySqlConn.getConn().createStatement();

            String query = String.format(SqlQueries.UPDATE_CLIENT,entity.getFirstname() , entity.getLastname() ,
            		entity.getEmail() , entity.getAddress() , entity.getId() );




            st.execute(query);



            
		System.out.println(entity.getFirstname());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	}

	





