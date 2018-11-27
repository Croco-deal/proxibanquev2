package fr.formation.proxi.metier.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.formation.proxi.persistence.AccountDao;
import fr.formation.proxi.persistence.MySqlConnection;
import fr.formation.proxi.persistence.SqlQueries;


/**
 * 
 * @author Omar & Sarah
 *
 * La classe AccountService contient les méthodes
 * qui font la relation entre la couche métier persistance et
 * la couche base de données.
 * On aura besoin d'une seule instance de cette classe(  Singleton )
 * qui s'occupera de notre relation
 */


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

	
	/**
	 * permet d'effectuer le virement d'un compte à un autre 
	 * compte du même client
	 * @param id_compte_emetteur
	 * @param id_compte_receveur
	 * @param amount
	 * @return boolean : si le crédit est suffisant retourne vrai sinon retourn faux
	 */

	public boolean transfer(Integer id_compte_emetteur, Integer id_compte_receveur, float amount) {
		boolean a = false;

		if (id_compte_emetteur != id_compte_receveur) {

			Account accountEmetteur = this.dao.read(id_compte_emetteur);
			Account accountReceveur = this.dao.read(id_compte_receveur);

			accountEmetteur.setBalance(accountEmetteur.getBalance() - amount);
			accountReceveur.setBalance(accountReceveur.getBalance() + amount);

			if (accountEmetteur.getBalance() > amount) {
				this.dao.update(accountReceveur);
				this.dao.update(accountEmetteur);

				a = true;
			} else {
				a = false;
			}
		} else {
			a = false;
		}

		return a;

	}
}


