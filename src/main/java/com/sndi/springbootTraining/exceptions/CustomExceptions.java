package com.sndi.springbootTraining.exceptions;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptions {

	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<Object> propertyValueExceptionHandler(PropertyValueException exception) {

		return new ResponseEntity<>("Merci de vérifier les valeurs saisies", HttpStatus.BAD_REQUEST);
	}

}
