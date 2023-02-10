package com.example.database.dao.save;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.dao.DAOException;
import com.example.database.entity.Cliente;

public class ClientiDAO extends AbstractDAO<Cliente, Integer> {

	private static Logger log = LogManager.getLogger();

	private static final String findAllQuery = "SELECT ID_CLIENTE, NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP FROM clienti";
	private static final String findByIdQuery = "SELECT ID_CLIENTE, NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP FROM clienti where ID_CLIENTE = ?";
	private static final String countQuery = "select count(*) from clienti";
	private static final String removeByIdQuery = "delete from clienti where ID_CLIENTE = ?";
	private static final String insertQuery = "insert into clienti (NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP) values(?, ?, ?, ?, ?, ?, ?)";

	// java multi-line String disponibile da Java 15
	private static final String updateQuery = """
			update clienti set
			nome = ?,
			cognome = ?, getConnection().
			email = ?,
			indirizzo = ?,
			citta = ?,
			provincia = ?,
			cap = ?
			where id_cliente = ?
			""";

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clienti = new ArrayList<>();
		try (PreparedStatement pst = getConnection().prepareStatement(findAllQuery);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				clienti.add(createCliente(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la findAll()", e);
		}

		return clienti;
	}

	private Cliente createCliente(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
		cliente.setNome(rs.getString("NOME"));
		cliente.setCognome(rs.getString("COGNOME"));
		cliente.setEmail(rs.getString("EMAIL"));
		cliente.setIndirizzo(rs.getString("INDIRIZZO"));
		cliente.setCitta(rs.getString("CITTA"));
		cliente.setProvincia(rs.getString("PROVINCIA"));
		cliente.setCap(rs.getString("CAP"));
		return cliente;
	}

	@Override
	public Cliente findById(Integer id) {
		Cliente cliente = null;
		ResultSet rs = null;
		try (PreparedStatement pst = getConnection().prepareStatement(findByIdQuery);) {
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				cliente = createCliente(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la findById()", e);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}

		return cliente;
	}

	/**
	 * La insert crea un nuova tupla nel DB ciò implica che l'istanza di Cliente sia
	 * incompleta perché idCliente non esiste (null); l'idCliente, una volta volta
	 * inserita la tupla, mi serve, quindi devo effettuare una retrieve dell'id
	 */
	@Override
	public Cliente create(Cliente entity) {
		log.trace("Inizio inserimento del cliente {}", entity);
		try (PreparedStatement pst = getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);) {
			preparazioneStatement(pst, entity);
			int numeroDegliUpdates = pst.executeUpdate();
			if (numeroDegliUpdates == 0) {
				throw new DAOException("Errore nell'inserimento di " + entity);
			}
			ResultSet keys = pst.getGeneratedKeys();
			if (!keys.next()) {
				throw new DAOException("Impossibile recuperare la chiave generata per " + entity);
			}
			entity.setIdCliente(keys.getInt(1)); // imposto la chiave generata
			log.debug("Cliente dopo inserimento ed assegnazione PK {}", entity);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la create()", e);
		}
		return entity;
	}

	private void preparazioneStatement(PreparedStatement pst, Cliente entity) throws SQLException {
		pst.setString(1, entity.getNome());
		pst.setString(2, entity.getCognome());
		pst.setString(3, entity.getEmail());
		pst.setString(4, entity.getIndirizzo());
		pst.setString(5, entity.getCitta());
		pst.setString(6, entity.getProvincia());
		pst.setString(7, entity.getCap());
	}

	@Override
	public Boolean merge(Cliente entity) {
		log.trace("Inizio aggiornamento del cliente {}", entity);

		if (!existsCliente(entity.getIdCliente())) {
			return false;
		}

		try (PreparedStatement pst = getConnection().prepareStatement(updateQuery);) {
			preparazioneStatement(pst, entity);
			pst.setInt(8, entity.getIdCliente());
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la merge()", e);
		}
	}

	@Override
	public Boolean removeById(Connection connection, Integer id) {

		if (!existsCliente(id)) {
			return false;
		}

		try (PreparedStatement pst = connection.prepareStatement(removeByIdQuery);) {
			pst.setInt(1, id);
			int numeroDegliUpdates = pst.executeUpdate();
			return numeroDegliUpdates > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la removeById()", e);
		}
	}

	private boolean existsCliente(Integer id) {
		Cliente c = findById(id);
		if (c == null) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean remove(Connection connection, Cliente entity) {
		return removeById(connection, entity.getIdCliente());
	}

	@Override
	public Long count() {
		Long count = 0l; // boxing (da tipo primitivo a oggetto wrapper)
		try (PreparedStatement pst = getConnection().prepareStatement(countQuery); ResultSet rs = pst.executeQuery();) {
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore durante la count()", e);
		}
		return count;
	}

	@Override
	public Boolean merge(Collection<Cliente> entities) {
		// TODO Auto-generated method stub
		return null;
	}

}
