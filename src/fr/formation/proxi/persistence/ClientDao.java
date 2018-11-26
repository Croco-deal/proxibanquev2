package fr.formation.proxi.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;

public class ClientDao implements Dao<Client> {

private final MySqlConnection mySqlConn;
	
	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
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
		//Client updatedClient = new Client();
		try {
		PreparedStatement preparedStatement = this.mySqlConn.getConn().prepareStatement(String.format(SqlQueries.UPDATE_CLIENT, entity.getId()));
		preparedStatement.setString(1, entity.getFirstname());
		preparedStatement.setString(2, entity.getLastname());
		preparedStatement.setString(3, entity.getEmail());
		preparedStatement.setString(4, entity.getAddress());
		preparedStatement.setInt(5, entity.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	}

	





