package com.order.production.exception;

public class CommandExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandExistException(Long commandNumber) {
		super("order already exist" +commandNumber);
	}

}
