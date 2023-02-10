package com.example.database.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.example.database.dao.save.ClientiDAO;
import com.example.database.entity.Cliente;

class ClientiDAOConnectionTest {

	@Test
	void Remove() {
		ClientiDAO dao = new ClientiDAO();
		boolean nCancellazioni = dao.removeById(getRandomCliente().getIdCliente());
		assert (nCancellazioni);
		System.out.println("eliminato:" + nCancellazioni);
	}

	private Cliente getRandomCliente() {
		ClientiDAO dao = new ClientiDAO();
		List<Cliente> clienti = dao.findAll();
		assert(clienti.size() > 0);
		return clienti.get( new Random().nextInt( clienti.size() ) );
	}
}
