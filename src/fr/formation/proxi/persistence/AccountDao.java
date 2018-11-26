package fr.formation.proxi.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;

public class AccountDao implements Dao<Account>{
	
	private final MySqlConnection mySqlConn;
	
	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}


	@Override
	public Account update(Account entity) {
		return entity;

	}

	@Override
	public List<Account> readAll() {

		List<Account> result = new ArrayList<>();

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.READ_ALL);
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String number  = rs.getString("number");
				float balance = Float.parseFloat( rs.getString("balance"));
				boolean savings = true;
				result.add(new Account( number , balance , savings));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
	}
}