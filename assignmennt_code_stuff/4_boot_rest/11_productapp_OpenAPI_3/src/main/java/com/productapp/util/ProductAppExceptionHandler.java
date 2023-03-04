package com.productapp.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ProductAppExceptionHandler {

	//------handle 404
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(ProductNotFoundException ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(404);
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setTimeStamp(LocalDateTime.now());
		errorInfo.setToContact("raj@gmail.com");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	
	//------need to handle MethodArgumentNotValidException 
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handle400(MethodArgumentNotValidException ex){
		 Map<String,String> errorMap=new HashMap<String, String>();
		 //now populate error in that map
		 ex.getBindingResult().getFieldErrors()
		 .forEach(e-> errorMap.put(e.getField(), e.getDefaultMessage()));
		return errorMap;
	}
}
