package com.example.database.dao;

import java.util.List;

/*
 * Definizione di un DAO generico
 * @param <ENTITY>
 * @param <KEY>
 */
public interface DAO<ENTITY, KEY> {

	/*
	 * Ricerca e ritorna tutte le occorrenze dell'entità
	 */
	List<ENTITY> findAll();
	
	/*
	 * Ricerca l'entità cui corrisponde la chiave
	 * @param id
	 * @return
	 */
	ENTITY findById (KEY id);
	
	/*
	 * Inserisce nel database una nuova entità
	 * @param entity
	 * @return
	 */
	ENTITY create(ENTITY entity);
	
	/*
	 * Aggiorna l'entità nel database
	 * @param entity
	 * @return
	 */
	Boolean merge(ENTITY entity);
	
	/*
	 * Elimina l'entità utilizzando la chiave
	 * @param id
	 * @return
	 */
	Boolean removeById(KEY id);
	
	/*
	 * Aggiorna l'entità nel database
	 * @param entity
	 * @return
	 */
	Boolean remove(ENTITY entity);
	
	/*
	 * Conta il numero di occorrenze nell'entità
	 */
	Long count();
}
