package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component(value = "foo")
public class Foo {

	
	private Bar bar;
	
	@Autowired
	private ObjectFactory<Bar> objectFactory;


	public Foo() {
		System.out.println("ctr of foo");
	}

	
	public void doWork() {
		this.bar=objectFactory.getObject();
		System.out.println(bar.getTime());
	}

	
}
