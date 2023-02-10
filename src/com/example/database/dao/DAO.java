package com.example.database.dao;

import java.util.Collection;
import java.util.List;

/**
 * Definizione di un DAO generico
 * @param <ENTITY>
 * @param <KEY>
 */
public interface DAO<ENTITY, KEY> {

	/**
	 * conta il numero delle occorrenze dell'entità
	 * @return
	 */
	Long count();

	/**
	 * Ricerca e ritorna tutte le occorrenze dell'entità
	 * @return
	 */
	List<ENTITY> findAll();

	/**
	 * Ricerca l'entità cui corrisponde la chiave
	 * @param id
	 * @return
	 */
	ENTITY findById(KEY id);

	/**
	 * Inserisce nel database una nuova entità
	 * @param entity
	 * @return
	 */
	ENTITY create(ENTITY entity);

	/**
	 * Inserisce nel database una nuova entità
	 * @param entity
	 * @return
	 */
	Collection<ENTITY> create(Collection<ENTITY> entities);

	/**
	 * Aggiorna l'entità nel database
	 * @param entity
	 * @return
	 */
	Boolean merge(ENTITY entity);

	/**
	 * Aggiorna una collection di entità
	 * @param id
	 * @return
	 */
	Boolean merge(Collection<ENTITY> entities);

	/**
	 * Elimina l'entità utilizzando la chiave
	 * @param id
	 * @return
	 */
	Boolean removeById(KEY id);

	/**
	 * Elimina l'entità utilizzando l'entità stessa
	 * @param id
	 * @return
	 */
	Boolean remove(ENTITY entity);

	/**
	 * Elimina Una collection di entità
	 * @param id
	 * @return
	 */
	Boolean remove(Collection<ENTITY> entities);


}
