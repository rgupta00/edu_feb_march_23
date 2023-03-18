package com.bankapp.restcontroller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice
public class ExHandlingRestController {

	//---------404-------
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex){
		
		ErrorInfo errorInfo=
				new ErrorInfo(ex.getMessage(),
						HttpStatus.NOT_FOUND.toString(), "rgupta.mtech@gmail.com",
						LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorInfo> handleDBExp(DataAccessException ex){
		
		ErrorInfo errorInfo=
				new ErrorInfo("constrant voilation",
						HttpStatus.INTERNAL_SERVER_ERROR.toString(), "rgupta.mtech@gmail.com",
						LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
	
	//MethodArgumentNotValidException
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handleValidationEx(MethodArgumentNotValidException ex){
		//how to extract error messages
		String errorMessage=ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		ErrorInfo errorInfo=
				new ErrorInfo(errorMessage,
						HttpStatus.BAD_REQUEST.toString(), "rgupta.mtech@gmail.com",
						LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}
}















