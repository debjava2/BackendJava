package io.springSecurity.jwt.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.springSecurity.jwt.GlobalException.CustomException.EmptyResultException;

@ControllerAdvice
public class MyAdviceController {

	@ExceptionHandler(EmptyResultException.class)
	public ResponseEntity<String> handleEmptyUserr(EmptyResultException emptyResultExpriont){
		return new ResponseEntity<String>("No matching user found",HttpStatus.BAD_REQUEST);
	}
}
