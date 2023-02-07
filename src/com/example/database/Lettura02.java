package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lettura02 {

	public static void main(String[] args) throws Exception {
		String dbUrl = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
		
		String query = "select id_regione, nome, sigla_automobilistica \r\n"
				+ "from province \r\n"
				+ "where id_regione in( SELECT id from regioni WHERE nome in(\"Lombardia\", \"Puglia\") ) -- inner select\r\n"
				+ "order by id_regione";
		
		// usare il ConnectionManager per ottenere una connessione al db
		Connection connection = DriverManager.getConnection(dbUrl);
		
		// creare uno statement che consenta l'invio della query e la ricezione dei risultati
		PreparedStatement pst = connection.prepareStatement(query);
		
		// ottengo un ResultSet pieno di dati
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String str = String.format("id_regione=%s \nnome: %s \nsigla automobilistica: %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
			System.out.println(str);
		}
		
		//le risorse vanno chiuse in ordine inverso	di apertura
		rs.close();
		
		pst.close();
		
		connection.close(); //risorsa da chiudere assolutamente
		
	}

}
