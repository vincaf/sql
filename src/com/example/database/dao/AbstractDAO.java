package com.example.database.dao;

import java.sql.Connection;

import com.example.database.util.ConnectionManager;

public abstract class AbstractDAO<ENTITY, KEY> implements DAO<ENTITY, KEY> {

	protected Connection getConnection() {
		return ConnectionManager.getInstance().createConnection();
	}

}