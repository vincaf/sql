package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lettura01 {

	public static void main(String[] args) throws Exception {
		String dbUrl = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
		
		String query = "SELECT id, nome, latitudine, longitudine FROM regioni";
		
		// usare il ConnectionManager per ottenere una connessione al db
		Connection connection = DriverManager.getConnection(dbUrl);
		
		// creare uno statement che consenta l'invio della query e la ricezione dei risultati
		PreparedStatement pst = connection.prepareStatement(query);
		
		// ottengo un ResultSet pieno di dati
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String str = String.format("id=%s regione=%s", rs.getInt(1), rs.getString(2));
			System.out.println(str);
		}
		
		//le risorse vanno chiuse in ordine inverso	di apertura
		rs.close();
		
		pst.close();
		
		connection.close(); //risorsa da chiudere assolutamente
		
	}

}
