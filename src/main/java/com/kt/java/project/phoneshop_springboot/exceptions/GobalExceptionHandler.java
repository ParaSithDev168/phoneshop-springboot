package com.kt.java.project.phoneshop_springboot.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GobalExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException ex) {
		ApiErrorException apiErrorEx = new ApiErrorException(ex.getHttpStatus(),ex.getMessage());
		return ResponseEntity.status(ex.getHttpStatus()).body(apiErrorEx);
	}
}
