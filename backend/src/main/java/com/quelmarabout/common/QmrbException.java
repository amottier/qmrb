package com.quelmarabout.common;

public class QmrbException extends Exception {

	private static final long serialVersionUID = -1654293486906726850L;

	public QmrbException(String message, Throwable cause) {
		super(message, cause);
	}

	public QmrbException(String message) {
		super(message);
	}

	public QmrbException(Throwable cause) {
		super(cause);
	}
	
}
