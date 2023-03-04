package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Magician magician=ctx.getBean("magician",Magician.class);
		
		//System.out.println(magician.getClass());
		magician.doMagic();
		magician.doEating();
		
	}
}
