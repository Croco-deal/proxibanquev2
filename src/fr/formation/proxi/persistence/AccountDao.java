package fr.formation.proxi.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.AccountService;
import fr.formation.proxi.metier.entity.Client;

public class AccountDao implements Dao<Account> {

	private final MySqlConnection mySqlConn;
	private final AccountService as;

	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
		this.as = AccountService.getInstance();
	}

	@Override
	public Account update(Account entity) {
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			 st.execute(String.format(SqlQueries.UPDATE_BALANCE, entity.getBalance(), entity.getId()));
			 System.out.println("BOULOULOULOU");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entity;
	}

	public List<Account> readAccountAll(Integer id) {

		List<Account> accounts = new ArrayList<>();

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.READ_ALL_ACCOUNT, id));
			while (rs.next()) {
				boolean savings;
				Integer id_account = Integer.parseInt(rs.getString("id"));
				String number = rs.getString("number");
				float balance = Float.parseFloat(rs.getString("balance"));
				String saving = rs.getString("savings");
				if (saving.equals("1"))
				{savings = true;}
				else { savings = false; }
				accounts.add(new Account(id_account,  number, balance, savings));
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

	
	
	public Account read(Integer id_compte) {
		Account account = new Account(id_compte);
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs1 = st.executeQuery(String.format(SqlQueries.READ_BALANCE, id_compte));
			rs1.next();
			
			float balance = Float.parseFloat(rs1.getString("balance"));
			account.setBalance(balance);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}


}