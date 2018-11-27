package fr.formation.proxi.metier.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.formation.proxi.persistence.AccountDao;
import fr.formation.proxi.persistence.MySqlConnection;
import fr.formation.proxi.persistence.SqlQueries;


public class AccountService {
	
	private static final AccountService INSTANCE = new AccountService();

	public static AccountService getInstance() {
		// TODO Auto-generated method stub
		return INSTANCE;
	}

	private final AccountDao dao;

	public AccountService() {
		this.dao = new AccountDao();
	}

	public List<Account> getAll(Integer id) {
		return this.dao.readAccountAll(id);
	}
	
//	public void read(Integer id_client) {
//		this.dao.read(Integer id_client);
//	}
	
	public boolean transfer(Integer id_compte_emetteur, Integer id_compte_receveur, float amount) {
		boolean a = false;
		
		Account accountEmetteur = this.dao.read(id_compte_emetteur);
		Account accountReceveur = this.dao.read(id_compte_receveur);
		
		accountEmetteur.setBalance(accountEmetteur.getBalance() - amount);
		accountReceveur.setBalance(accountReceveur.getBalance() + amount);
		
		if(accountEmetteur.getBalance()>amount) {
		
		this.dao.update(accountReceveur);
		this.dao.update(accountEmetteur);
		System.out.println("BALALALALALALAL");
		
		a = true;
		} else {
			a = false;
		}
		 return a;
	
	}
}		
	
//	public Account transfer(Integer id_compte_emetteur , Integer id_compte_receveur , float montant) {
//		return this.dao.transfer(id_compte_emetteur,id_compte_receveur,montant);

