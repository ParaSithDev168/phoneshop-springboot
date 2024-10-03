package com.kt.java.project.phoneshop_springboot.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorException {
	private final HttpStatus httpStatus;
	private final String message;
}
