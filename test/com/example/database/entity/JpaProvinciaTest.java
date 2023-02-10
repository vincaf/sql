package com.example.database.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class JpaProvinciaTest {
	private static Logger log = LogManager.getLogger();
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

	@Test
	void testFindAll() {
		
		// creo l'equivalente della connessione
		EntityManager em = emf.createEntityManager();
		log.trace("Entity manager creato");
		
		// query jpql per elencare tutte le province
		String jpql = "select e from Provincia e";
		
		// equivalente del jdbc PreparedStatement per JPA
		TypedQuery<Provincia> tq = em.createQuery(jpql, Provincia.class);
		
		// ottengo il risultato equivalente al ResultSet
		List<Provincia> province = tq.getResultList();
		province.forEach(log::debug);
		em.close();
	}

}