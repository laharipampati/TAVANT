package com.tav.test.exception;

public class ModelNotFoundException extends Exception {

	
	//private static final long serialVersionUID = 1L;
	
	public ModelNotFoundException(String msg) {
		super(msg);
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ this.getMessage() ;
	}

	
}
