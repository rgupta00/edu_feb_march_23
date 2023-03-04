package com.bankapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	
	@Around("@annotation(com.bankapp.service.aspect.MyAppLogger)")
	public Object aroundLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String targetMethodName=proceedingJoinPoint.getSignature().getName();
		
		long start = System.currentTimeMillis();

		Object value = proceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		logger.info("time taken to call " +targetMethodName+ "() method is " + (end - start) + " ms");
		return value;
	}
	
	
	
	
//	@Around("execution( * com.bankapp.service..*Impl.*(..))")
//	public Object aroundLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		
//		String targetMethodName=proceedingJoinPoint.getSignature().getName();
//		
//		long start = System.currentTimeMillis();
//
//		Object value = proceedingJoinPoint.proceed();
//
//		long end = System.currentTimeMillis();
//
//		logger.info("time taken to call " +targetMethodName+ "() method is " + (end - start) + " ms");
//		return value;
//	}
}
