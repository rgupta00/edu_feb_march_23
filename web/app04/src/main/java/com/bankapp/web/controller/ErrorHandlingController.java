package com.bankapp.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bankapp.model.exceptions.BankAccountNotFoundException;

@ControllerAdvice// it is using spring aop under the hood to handle the ex in our controller
public class ErrorHandlingController {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle404() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("404");
		mv.addObject("message", "page not found");
		return mv;
	}
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ModelAndView handleAccountNotFoundEx(BankAccountNotFoundException ex) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("account_not_found");
		mv.addObject("message", ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDataAccessEx(DataAccessException ex) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("internal_server_error");
		mv.addObject("message", ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handle500(Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("internal_server_error");
		mv.addObject("message","pls try after some time");
		return mv;
	}
}
