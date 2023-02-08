package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utilizzo di try With Resources vedere interfaccia AutoCloseable
 */
public class Lettura04 {

	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {

		String dbUrl = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";

		String query = new StringBuilder().append("select id_regione, nome, sigla_automobilistica\n")
				.append("from province p\n")
				.append("where id_regione in( select id from regioni where nome in (?, ?) ) -- inner select\n")
				.append("order by id_regione").toString();

		System.out.println(query);

		ResultSet rs = null;
		try (
				Connection connection = DriverManager.getConnection(dbUrl);
				PreparedStatement pst = connection.prepareStatement(query);
				MyClass myClass = new MyClass();

				) {
			// set dei parametri se query parametrica
			pst.setString(1, "Puglia");
			pst.setString(2, "Lombardia");
			rs = pst.executeQuery();
			while (rs.next()) {
				String str = String.format("id=%s regione=%s", rs.getInt(1), rs.getString(2));
				System.out.println(str);
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

class MyClass implements AutoCloseable {

	@Override
	public void close() throws SQLException {
		System.out.println("\n\nChiamato il metodo close() ....\n");
	}

}





