package fr.formation.proxi.persistence;

public class SqlQueries {
	
	public static final String READ_ALL = "SELECT * FROM client;";
	public static final String UPDATE_CLIENT = "INSERT INTO article VALUES (null, '%s', '%s');";
	public static final String DELETE_ARTICLE = "DELETE FROM article where id = %s;";


}
