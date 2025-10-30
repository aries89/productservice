package com.example.productservice.exceptions;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1673335971192053783L;

	public ProductNotFoundException(Long id) {
		super("Product with id: "+id+" not found");
	}

}
