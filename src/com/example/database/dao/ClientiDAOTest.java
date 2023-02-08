package com.example.database.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.example.database.entity.Cliente;

class ClientiDAOTest {

	@Test
	void testFindAll() {
		ClientiDAO dao = new ClientiDAO();

		List<Cliente> clienti = dao.findAll();

		assert(clienti.size() > 0);

		clienti.forEach(System.out::println);
	}
	
	@Test
	void testFindById() {
		ClientiDAO dao = new ClientiDAO();
		
		Cliente cliente = dao.findById(getRandomCliente().getIdCliente());

		assertTrue(cliente != null);

		System.out.println(cliente);
	}

	@Test
	void testFindById2() {
		ClientiDAO dao = new ClientiDAO();
		
		Cliente cliente = dao.findById( -1 );

		assertTrue(cliente == null);

		System.out.println(cliente);
	}

	private Cliente getRandomCliente() {
		ClientiDAO dao = new ClientiDAO();
		List<Cliente> clienti = dao.findAll();
		assert(clienti.size() > 0);
		return clienti.get( new Random().nextInt(clienti.size() ) );
	}
}
