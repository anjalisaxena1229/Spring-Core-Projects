package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)  //@ResponseStatus marks a method or exception class with the status code and reason message that should be returned
public class ResourceNotFoundException extends RuntimeException{
//whenever Rest APi throw RNFE then this http status will be send to client
	
	
	private String fieldName;
	private Object fieldValue;
	private String resourceName;
	
	public ResourceNotFoundException(String fieldName, Object fieldValue, String resourceName) {
		super(String.format("%s not found with %s:'%s' ", resourceName,fieldName,fieldValue));
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.resourceName = resourceName;
	}
	public ResourceNotFoundException() {
		System.out.print("Not Found");
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}
	
	
	
}
