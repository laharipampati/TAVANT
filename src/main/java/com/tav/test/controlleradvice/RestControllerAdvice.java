package com.tav.test.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tav.test.errorresponse.ErrorResponse;
import com.tav.test.exception.ModelNotFoundException;
import com.tav.test.exception.NoDataFoundException;

@ControllerAdvice
public class RestControllerAdvice {

@ExceptionHandler(ModelNotFoundException.class)
	
	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(
			ModelNotFoundException e,WebRequest request){
		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	
	public final ResponseEntity<ErrorResponse> handleNoDataFoundException(
			NoDataFoundException e,WebRequest request){
		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		
		ErrorResponse errorResponse = new ErrorResponse("CANNOT FIND DATA",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
