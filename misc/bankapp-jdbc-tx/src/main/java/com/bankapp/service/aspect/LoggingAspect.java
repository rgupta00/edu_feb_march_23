package com.bankapp.service.aspect;

import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.ConnectionImpl;

@Service
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

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
	
	@Around("target(javax.sql.DataSource)")
	public Object connectionTracker(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("database tracker :"+proceedingJoinPoint.getSignature());
		Object returnedObj = proceedingJoinPoint.proceed();
		
		if(returnedObj instanceof Connection) {
			Connection connection=
					(Connection) Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(), new Class[] {Connection.class}, 
							new ConnInvocationHandler((Connection) returnedObj));
			return connection;
		}
	//	System.out.println(returnedObj);
		return returnedObj;
		
	}
}

















