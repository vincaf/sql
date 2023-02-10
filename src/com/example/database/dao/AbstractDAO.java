package com.example.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.util.ConnectionManager;

public abstract class AbstractDAO<ENTITY, KEY> implements DAO<ENTITY, KEY> {
	private static Logger log = LogManager.getLogger();

	public AbstractDAO() {}

	/**
	 * Crea una connessione verso il DB.
	 * Metodo accessibile solo alla gerarchia od al package
	 * @return
	 */
	protected Connection getConnection() {
		return ConnectionManager.getInstance().createConnection();
	}

	@Override
	public Long count() {
		throw new DAOMethodNotYetImplementedException("count() not yet implemented ...");
	}

	@Override
	public List<ENTITY> findAll() {
		throw new DAOMethodNotYetImplementedException("findAll() not yet implemented ...");
	}

	@Override
	public ENTITY findById(KEY id) {
		throw new DAOMethodNotYetImplementedException("findById(KEY id) not yet implemented ...");
	}

	@Override
	public ENTITY create(ENTITY entity) {
		List<ENTITY> lista = new ArrayList<>(1);
		lista.add(entity);
		for(ENTITY e : create(lista) ) {
			return e; // da ottimizzare

		}
		return null;
	}

	@Override
	public Collection<ENTITY> create(Collection<ENTITY> entities) {
		throw new DAOMethodNotYetImplementedException("create(Collection<ENTITY> entities) not yet implemented ...");
	}

	@Override
	public Boolean merge(ENTITY entity) {
		Collection<ENTITY> collection = new ArrayList<>(1);
		collection.add(entity);
		return merge(collection);
	}

	@Override
	public Boolean merge(Collection<ENTITY> entities) {
		throw new DAOMethodNotYetImplementedException("merge(Collection<ENTITY> entities) not yet implemented ...");
	}

	@Override
	public Boolean removeById(KEY id) {
		ENTITY entity = findById(id);
		if(entity == null) {
			return false;
		}
		return remove(entity);
	}

	@Override
	public Boolean remove(ENTITY entity) {
		Collection<ENTITY> collection = new ArrayList<>(1);
		collection.add(entity);
		return remove(collection);
	}

	protected abstract PreparedStatement createRemovePreparedStatement(Connection connection) throws SQLException;
	protected abstract void setValuesForRemove(PreparedStatement pst, ENTITY entity) throws SQLException ;

	@Override
	public Boolean remove(Collection<ENTITY> entities) {
		Boolean truth = false;

		try (Connection connection = ConnectionManager.getInstance().createConnection();
				) {
			boolean autoCommit = connection.getAutoCommit(); // init with backup
			connection.setAutoCommit(false); // START TRANSACTION

			// 1) devo creare il prepared statement, lo prepara la classe figlio di AbstractDAO
			PreparedStatement pst = createRemovePreparedStatement(connection);

			for(ENTITY entity : entities) {
				// 2) devo settare i valori, li setta la classe figlio di AbstractDAO
				setValuesForRemove(pst, entity);

				// 3) devo effettuare l'update
				pst.addBatch(); // non esegue lo statement ma lo mette in coda
			}

			int [] allRemoved = pst.executeBatch(); // esegue tutti gli statement in coda

			int count = 0;
			for(int cell : allRemoved) {
				if(cell>1) { cell = 0; } // se ho aggiornato + di un row allora è un errore
				count += cell;
			}

			// è andato tutto bene se il numero delle row aggiornate è uguale alla dimensione della collection
			truth = count == entities.size();

			// si decide se confermare i cambiamenti oppure annullarli
			if(truth) {
				connection.commit();
			} else {
				connection.rollback();
			}

			connection.setAutoCommit(autoCommit); // restore
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la remove(Collection<ENTITY> entities)", e);
		}

		return truth;
	}


}
