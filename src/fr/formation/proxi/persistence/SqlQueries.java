package fr.formation.proxi.persistence;

public class SqlQueries {
	
	public static final String READ_ALL = "SELECT * FROM article;";
	public static final String UPDATE_CLIENT = "UPDATE Client set firstname=?, lastname=?; email=?; address=?; where id=?;";;
	public static final String DELETE_ARTICLE = "DELETE FROM article where id = %s;";


}
