package com.order.production.exception;

public class ProductAlreadyExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductAlreadyExistException(String name) {
		super("product already exist"+name);
	}

}
