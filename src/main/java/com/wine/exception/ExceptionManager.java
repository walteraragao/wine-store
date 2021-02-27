package com.wine.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wine.exception.runtime.*;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(RequiredFieldException.class)
	public ResponseEntity<TemplateError> requiredField(RequiredFieldException e,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new TemplateError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()));
	}
	
	@ExceptionHandler(ZipCodeRangeInvalidException.class)
	public ResponseEntity<TemplateError> zipCodeInvalid(ZipCodeRangeInvalidException e,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new TemplateError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()));
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<TemplateError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new TemplateError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis()));
	}

	@ExceptionHandler(ObjectAlreadyExistsException.class)
	public ResponseEntity<TemplateError> ObjectAlreadyExists(ObjectAlreadyExistsException e,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new TemplateError(HttpStatus.FOUND.value(), e.getMessage(), System.currentTimeMillis()));
	}

	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<TemplateError> TechnicalException(TechnicalException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TemplateError(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), System.currentTimeMillis()));
	}

}
