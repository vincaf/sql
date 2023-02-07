package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lettura03 {

	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) throws Exception {
		String dbUrl = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
		
//		String query = "select id_regione, nome, sigla_automobilistica \r\n"
//				+ "from province \r\n"
//				+ "where id_regione in( SELECT id from regioni WHERE nome in(\"Lombardia\", \"Puglia\") ) -- inner select\r\n"
//				+ "order by id_regione";
		
		String query = new StringBuilder().append("select id_regione, nome, sigla_automobilistica \\r\\n")
						.append("from province \r\n")
						.append("where id_regione in( SELECT id from regioni WHERE nome in(\"Lombardia\", \"Puglia\") )")
						.append("order by id_regione").toString();
		
		System.out.println(query);
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(dbUrl);
			log.trace("connection acquisita");
			
			pst = connection.prepareStatement(query);
			log.trace("statement preparato");
			
			rs = pst.executeQuery();
			log.trace("query eseguita");
			
			while(rs.next()) {
				String str = String.format("id_regione=%s \nnome: %s \nsigla automobilistica: %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(str);
			}
			
		} catch (SQLException e) {
			log.trace("inizio gestione exception");
			e.printStackTrace();
			System.out.println("È occorso un errore");
			log.trace("fine gestione exception");
			
		} finally {
			log.trace("inizio blocco finally");
			
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			log.trace("result set chiuso");
			
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			log.trace("prepared statement chiuso");
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			log.trace("connection chiuso");
			
			log.trace("fine blocco finally");
		}
	}

}
