package com.kt.java.project.phoneshop_springboot.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{

	
	public ResourceNotFoundException(String resourceName , Integer id) {
		super(HttpStatus.NOT_FOUND, "%s with id %d not found".formatted(resourceName,id));
	}

	

}
