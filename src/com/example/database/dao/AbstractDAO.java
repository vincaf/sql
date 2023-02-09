package com.example.database.dao;

import java.sql.Connection;
import java.util.Collection;

import com.example.database.util.ConnectionManager;

// implementazione dei loop rende l'idea
// ma così com'è è assolutamente sbagliata
// queste attività devono essere effettuate sotto il controllo di una transazione
public abstract class AbstractDAO<ENTITY, KEY> implements DAO<ENTITY, KEY> {

	protected Connection getConnection() {
		return ConnectionManager.getInstance().createConnection();
	}

	@Override
	public Collection<ENTITY> create(Collection<ENTITY> entities) {
		entities.forEach(entity -> create(entity));
		return entities;
	}

	@Override
	public Boolean remove(Collection<ENTITY> entities) {
		Boolean allRemoved = true;
		for (ENTITY entity : entities) {
			allRemoved &= remove(entity);
		}
		return allRemoved;
	}
}
