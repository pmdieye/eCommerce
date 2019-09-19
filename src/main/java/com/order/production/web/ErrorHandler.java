package com.order.production.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.order.production.exception.CommandExistException;
import com.order.production.exception.OrderNotFoundException;
import com.order.production.exception.ProductAlreadyExistException;
import com.order.production.exception.ProductNotFoundException;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(CommandExistException.class)
	public ResponseEntity<String> handlerCommandExistException(CommandExistException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> orderNotFoundException(OrderNotFoundException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(ProductNotFoundException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(ProductAlreadyExistException.class)
	public ResponseEntity<String> ProductAlreadyExistException(ProductAlreadyExistException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}



}
