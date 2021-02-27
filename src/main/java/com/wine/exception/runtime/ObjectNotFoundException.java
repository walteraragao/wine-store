package com.wine.exception.runtime;

public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public ObjectNotFoundException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}