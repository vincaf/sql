package com.example.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.entity.Cliente;
import com.example.database.util.ConnectionManager;

public class ClientiDAO extends AbstractDAO<Cliente, Integer> {
	private static Logger log = LogManager.getLogger();

	private static final String findAllQuery = "SELECT ID_CLIENTE, NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP FROM clienti";
	private static final String findByIdQuery = "SELECT ID_CLIENTE, NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP FROM clienti where ID_CLIENTE = ?";
	private static final String countQuery = "select count(*) from clienti";
	private static final String removeByIdQuery = "delete from clienti where ID_CLIENTE = ?";
	private static final String insertQuery = "insert into clienti (NOME, COGNOME, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP) values(?, ?, ?, ?, ?, ?, ?)";

	@Override
	protected PreparedStatement createRemovePreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement(removeByIdQuery);
	}

	@Override
	protected void setValuesForRemove(PreparedStatement pst, Cliente entity) throws SQLException {
		pst.setInt(1, entity.getIdCliente());
	}






}
