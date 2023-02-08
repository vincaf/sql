package com.example.database.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.database.util.ConnectionManager;

public abstract class AbstractDAO<ENTITY, KEY> implements DAO<ENTITY, KEY> {

	protected Connection getConnection() { //nprovvisorio
		try {
			return ConnectionManager.getInstance().createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
