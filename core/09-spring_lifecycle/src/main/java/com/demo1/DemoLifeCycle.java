package com.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoLifeCycle {

	public static void main(String[] args) {

		//register shut down hook
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("demo1.xml");
		ctx.registerShutdownHook();
		
		
		Foo foo=ctx.getBean("foo", Foo.class);
		
		foo.doWork();
		
		foo.doWork();
		
	}
}
