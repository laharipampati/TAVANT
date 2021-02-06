package com.tav.test.exception;

public class NoDataFoundException extends Exception {

	//private static final long serialVersionUID = 1L;

	public NoDataFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}	
	
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ this.getMessage() ;
	}

	
}
