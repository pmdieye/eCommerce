package com.order.production.exception;

public class OrderNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2589252749793304974L;

	public OrderNotFoundException(Long commandNumber) {
		// TODO Auto-generated constructor stub
		super("not found order " + commandNumber);
		

	}

}
