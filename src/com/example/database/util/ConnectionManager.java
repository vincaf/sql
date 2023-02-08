package com.example.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// requisiti: non sotto-classabile (non estensibile)
// se ne può creare un unica istanza ==> deve implementare il pattern Singleton
/**
 * https://it.wikipedia.org/wiki/Singleton_(informatica)
 * classe che implementa il pattern Singleton
 * Il singleton è un design pattern creazionale che ha lo scopo di garantire che
 * di una determinata classe venga creata una e una sola istanza, e di fornire
 * un punto di accesso globale a tale istanza.
 */
public class ConnectionManager {
	private static Logger log = LogManager.getLogger();

	String dbUrl = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";

	private final static ConnectionManager instance = new ConnectionManager();

	private ConnectionManager() {
		log.trace("Creazione istanza di ConnectionManager");
	}

	/**
	 * Classe per generare connessioni al database
	 * @return la java.sql.Connection necessaria
	 * @throws SQLException
	 */
	public Connection createConnection() throws SQLException {
		log.trace("Rilascio di un'istanza di Connection");
		Connection connection = DriverManager.getConnection(dbUrl); // 1) connessione
		return connection;
	}

	public static ConnectionManager getInstance() {
		return instance;
	}

}