package com.example.database.util;

public class ConnectionManagerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConnectionManagerException() {
	}

	public ConnectionManagerException(String message) {
		super(message);
	}

	public ConnectionManagerException(Throwable cause) {
		super(cause);
	}

	public ConnectionManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionManagerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
