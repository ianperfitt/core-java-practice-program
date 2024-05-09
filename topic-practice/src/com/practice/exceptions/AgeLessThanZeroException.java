package com.practice.exceptions;

public class AgeLessThanZeroException extends Exception {

	private static final long serialVersionUID = 1L;

	public AgeLessThanZeroException() {

	}

	public AgeLessThanZeroException(String message) {
		super(message);
	}

	public AgeLessThanZeroException(Throwable cause) {
		super(cause);
	}

	public AgeLessThanZeroException(String message, Throwable cause) {
		super(message, cause);
	}

}
