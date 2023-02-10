package com.example.database.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.example.database.dao.save.ClientiDAO;
import com.example.database.entity.Cliente;

class ClientiDAOTest {

	@Test
	void testCount() {
		ClientiDAO dao = new ClientiDAO();
		Long count = dao.count();
		assert(count >= 0l);
		System.out.println("count="+count);
	}

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
		Cliente cliente = dao.findById( getRandomCliente().getIdCliente() );
		assertTrue(cliente != null);
		System.out.println(cliente);
	}

	@Test
	void testFindById2() {
		ClientiDAO dao = new ClientiDAO();
		Cliente cliente = dao.findById( -1 );
		assertTrue(cliente == null);
	}

	private Cliente getRandomCliente() {
		ClientiDAO dao = new ClientiDAO();
		List<Cliente> clienti = dao.findAll();
		assert(clienti.size() > 0);
		return clienti.get( new Random().nextInt( clienti.size() ) );
	}

	@Test
	void testCreate() {
		ClientiDAO dao = new ClientiDAO();
		Cliente cliente = dao.create(generaNuovoCliente());
		assert(cliente.getIdCliente() != null);
		System.out.println("Inserito "+cliente);
	}

	@Test
	void testUpdate() {
		ClientiDAO dao = new ClientiDAO();
		Cliente cliente = dao.findById( getRandomCliente().getIdCliente() );
		assert(cliente.getIdCliente() != null);
		cliente.setIndirizzo( cliente.getIndirizzo().toUpperCase() );
		System.out.println("Aggiornato "+cliente+ " "+dao.merge(cliente));
	}

	private Cliente generaNuovoCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("nuovo");
		cliente.setCognome("cliente");
		cliente.setEmail("nuovo.cliente@gmail.com");
		cliente.setIndirizzo("Via della nazione, 22");
		cliente.setCitta("Roma");
		cliente.setProvincia("RM");
		cliente.setCap("00100");
		return cliente;
	}

}
