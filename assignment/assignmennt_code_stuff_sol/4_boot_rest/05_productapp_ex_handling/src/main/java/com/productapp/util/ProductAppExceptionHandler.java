package com.productapp.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handle500(Exception ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(500);
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setTimeStamp(LocalDateTime.now());
		errorInfo.setToContact("raj@gmail.com");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
}
