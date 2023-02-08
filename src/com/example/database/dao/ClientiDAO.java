package com.example.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.database.entity.Cliente;

public class ClientiDAO extends AbstractDAO<Cliente, Integer> {

	private static final String findAllQuery = "SELECT ID_CLIENTE, NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP FROM clienti";
	private static final String findByIdQuery = "SELECT ID_CLIENTE, NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP FROM clienti where ID_CLIENTE = ?";

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
			try { rs.close(); } catch (Exception e) {}
		}

		return cliente;
	}

	@Override
	public Cliente create(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean merge(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}