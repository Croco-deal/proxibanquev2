package fr.formation.proxi.persistence;

import java.util.List;

/**
 * Définition d'une interface comportant les 4 méthodes 
 * élémentaires de manipulation de données (C.R.U.D.) + redAll. 
 * @author Adminl Sarah & Omar
 * @param <T> classe qui représente le type de données manipulées par le DAO 
 *
 */
public interface Dao<T> {
	
	/**
	 * Met à jour l'entité donnée dans la BDD
	 * @param entity l'entité à mettre à jour avec ses nouvelles informations 
	 * @return T l'entité mise à jour
	 */
	public T update(T entity);
	
	
	/** 
	 * Récupère toutes les entités (lignes) d'une d'une table
	 * @return List<T> renvoie la liste des objets générés, de toutes les entités lues
	 */
	public List<T> readAll();
	
	
	/** 
	 * Récupère toutes les entités (lignes) d'une d'une table
	 * @return List<T> renvoie la liste des objets générés, de toutes les entités lues
	 */
	public T transfer(T entity);

}
