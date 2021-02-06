package com.tav.test.exception;

public class EmptyObjectException extends Exception{

	public EmptyObjectException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ this.getMessage();
	}
	
}
