package fr.formation.proxi.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.Client;

public class AccountDao implements Dao<Account>{
	
	private final MySqlConnection mySqlConn;
	private final AccountService as;

	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
		this.as = AccountService.getInstance();
	}

	@Override
	public Account update(Account entity) {
		return entity;
	}

	
	public List<Account> readAccountAll(Integer id) {

		List<Account> accounts = new ArrayList<>();

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ALL_ACCOUNT , id));
			while (rs.next()) {
				String number  = rs.getString("number");
				float balance = Float.parseFloat( rs.getString("balance"));
				boolean savings = true;
				accounts.add(new Account( number , balance , savings));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return accounts;
	}

	@Override
	public List<Account> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Account transfer() {
//		
//	}
}