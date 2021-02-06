package com.tav.test.errorresponse;

import java.io.Serializable;

import org.springframework.validation.FieldError;

import lombok.Data;

@Data
public class ApiValidationError extends ApiSubError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  object;
	private String field;
	private Object rejectedValue;
	private String message;
	
	public ApiValidationError(String object,String message) {
		// TODO Auto-generated constructor stub
		this.object=object;
		this.message=message;
		
	}

	public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		super();
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}
	//do we need to read the errors which are coming for validation annotations
	
	
}
