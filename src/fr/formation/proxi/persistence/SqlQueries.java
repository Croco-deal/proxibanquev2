package fr.formation.proxi.persistence;

public class SqlQueries {
	
	public static final String READ_ALL = "SELECT * FROM client;";
	public static final String UPDATE_CLIENT = "UPDATE Client set firstname='%s', lastname='%s', email='%s', address='%s' where id=%s;";

}
