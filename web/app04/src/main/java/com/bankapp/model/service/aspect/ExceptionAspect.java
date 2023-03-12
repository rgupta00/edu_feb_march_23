package com.bankapp.model.service.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class ExceptionAspect {

	private Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

	@AfterThrowing(value = "execution( * com.bankapp.service..*Impl.*(..) )", throwing = "ex")
	public void handleExceptions(Exception ex)  {
		
		logger.error("Exception occured: "+ ex.getMessage());
		
	}
}
