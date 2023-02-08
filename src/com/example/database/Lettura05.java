package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.util.ConnectionManager;

/**
 * Utilizzo di try With Resources vedere interfaccia AutoCloseable
 */
public class Lettura05 {

	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {

		String query = new StringBuilder().append("select id_regione, nome, sigla_automobilistica\n")
				.append("from province p\n")
				.append("where id_regione in( select id from regioni where nome in (?, ?) ) -- inner select\n")
				.append("order by id_regione").toString();

		System.out.println(query);

		ResultSet rs = null;
		try (
				Connection connection = ConnectionManager.getInstance().createConnection();
				PreparedStatement pst = connection.prepareStatement(query); // 2) inizia da qui

				) {
			// set dei parametri se query parametrica
			pst.setString(1, "Puglia"); // 2)
			pst.setString(2, "Lombardia"); // 2)
			rs = pst.executeQuery(); //2) si occupa della query finisce qui
			while (rs.next()) {
				String str = String.format("id=%s regione=%s", rs.getInt(1), rs.getString(2));
				System.out.println(str); // 3) risolve il problema di business
			}

		} catch (SQLException e) {
			log.trace("inizio gestione Exception");
			e.printStackTrace(); // stampa la stack trace
			System.out.println("E' occorso un errore");
			log.trace("fine gestione Exception");
		} finally {
			log.trace("inizio blocco finally");

			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.trace("result set chiuso");

			log.trace("fine blocco finally");
		}

	}

}