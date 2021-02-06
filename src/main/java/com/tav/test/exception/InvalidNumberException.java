package com.tav.test.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidNumberException extends Exception {

	
	private static final long serialVersionUID = 1409962974905278968L;

	public InvalidNumberException(String message) {
		super(message);
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() ;
	}
}
