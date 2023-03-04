package com.demo;
//Aspect=way to handle ccc =  pointcut + advice

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudianceAspect {
	
	
	//Act as a servlet filter: spring sec @Secure, tx:@Tranastional
	//.. means 0 to N
	//*  means 1 to N
	
	@Around("execution( * com.demo..*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("magic is starting ...");
		long start= System.currentTimeMillis();
		
		Object returnValue= proceedingJoinPoint.proceed();
		
		System.out.println("magic is end ...");
		
		long end= System.currentTimeMillis();
		
		System.out.println("time taken: "+ (end-start)+" ms");
		return   returnValue;
	}
	
	
	
//	@After("execution(public void doMagic())")
//	public void clapping() {
//		System.out.println(" wow maza aa gaya");
//	}
	
//	@Before("execution(public void doMagic())")
//	public void clapping() {
//		System.out.println(" wow maza aa gaya");
//	}
	
	//do ex in rest api
	@AfterThrowing(pointcut = "execution(public String doMagic())", throwing = "ex")
	public void handleEx(Exception ex) {
		System.out.println("----------------------------");
		System.out.println(ex);
		System.out.println(ex.getMessage());
	}
	
	
	//@AfterReturning vs @After
	
	//@AfterReturning: will only run iff target method executed "Succesfully"
	@AfterReturning(pointcut = "execution(public String doMagic())", returning = "rabbit")
	public void clapping(String rabbit) {
		System.out.println(rabbit);
		System.out.println(" wow maza aa gaya");
	}
	
//	@After("execution(public void doMagic())")
//	public void clappingAfter() {
//		System.out.println(" wow maza aa gaya: After");
//	}
}




//
//@Pointcut("execution(public void doMagic())")
//public void myPointCut() {}
//
//@After("myPointCut()")
//public void clapping() {
//	System.out.println(" wow maza aa gaya");
//}