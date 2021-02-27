package com.wine.exception.runtime;

public class ZipCodeRangeInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ZipCodeRangeInvalidException(String mensagem) {
		super(mensagem);
	}
	
	public ZipCodeRangeInvalidException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
