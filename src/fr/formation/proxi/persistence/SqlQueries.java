package fr.formation.proxi.persistence;

public class SqlQueries {
	
	public static final String READ_ALL = "SELECT * FROM client;";
	public static final String UPDATE_CLIENT = "UPDATE Client set firstname='%s', lastname='%s', email='%s', address='%s' where id=%s;";
	public static final String READ_ALL_ACCOUNT = "SELECT * from compte where id_client = %s";
	public static final String READ_ACCOUNT = "SELECT * from compte where id = %s ";
	public static final String READ = "SELECT firstname, lastname, address, email FROM Client where id=%s;";
	public static final String READ_BALANCE = "SELECT balance FROM compte where id=%s;";
	public static final String UPDATE_BALANCE = "UPDATE COMPTE set balance=%s where id=%s;";
	

}
