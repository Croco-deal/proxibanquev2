package fr.formation.proxi.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
				result.add(new Client(firstname , lastname , email , address));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	
	}


	}

	





