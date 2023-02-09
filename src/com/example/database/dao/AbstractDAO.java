package com.example.database.dao;

import java.sql.Connection;
import java.sql.SQLException;
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


	abstract Boolean removeById(Connection connection, KEY id);

	abstract Boolean remove(Connection connection, ENTITY entity);



	@Override
	public Boolean remove(Collection<ENTITY> entities) {
		Boolean allRemoved = true;

		try (Connection connection = ConnectionManager.getInstance().createConnection();
				) {
			boolean autoCommit = connection.getAutoCommit(); // init with backup

			connection.setAutoCommit(false); // START TRANSACTION

			for (ENTITY entity : entities) {
				allRemoved &= remove(connection, entity);
			}
			if(allRemoved) {
				connection.commit();
			} else {
				connection.rollback();
			}

			connection.setAutoCommit(autoCommit); // restore

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la remove(Collection<ENTITY> entities)", e);
		}

		return allRemoved;
	}

	public Boolean removeById(KEY id) {
		try (Connection connection = ConnectionManager.getInstance().createConnection();
				) {
			return removeById(connection, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la removeById(KEY id)", e);
		}
	}

	public Boolean remove(ENTITY entity) {

		try (Connection connection = ConnectionManager.getInstance().createConnection();
				) {
			return remove(connection, entity);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la remove(ENTITY entity)", e);
		}
	}
}
