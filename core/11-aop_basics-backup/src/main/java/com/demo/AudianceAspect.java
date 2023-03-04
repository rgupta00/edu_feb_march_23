package com.demo;
//Aspect=way to handle ccc =  pointcut + advice

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudianceAspect {
	
	@Pointcut("execution(public void doMagic())")
	public void myPointCut() {}
	
	@After("myPointCut()")
	public void clapping() {
		System.out.println(" wow maza aa gaya");
	}
}
