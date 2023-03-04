package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		
		Foo foo=ctx.getBean("foo", Foo.class);
	
		foo.doWork();
		
		Foo foo2=ctx.getBean("foo", Foo.class);
		
		foo.doWork();
	}
}
