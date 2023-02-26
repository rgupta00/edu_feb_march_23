package com.demo0;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean, DisposableBean, BeanNameAware{

	private String message;
	
	public Foo() {
		System.out.println("ctr of foo");
	}

	
	public String getMessage() {
		return message;
	}
	
	@PostConstruct
	public void annoWalaInitMethod() {
		System.out.println("annoWalaInitMethod is called @PostConstruct");
	}
	
	
	public void xmlWalaInitMethod() {
		System.out.println("xmlWalaInitMethod is called");
	}
	

	public void xmlWalaDestroyMethod() {
		System.out.println("xmlWalaDestroyMethod is called");
	}
	
	@PreDestroy
	public void annoWalaDestroyMethod() {
		System.out.println("annoWalaDestroyMethod is called @PreDestroy");
	}
	
	
	public void setMessage(String message) {
		System.out.println("it is setter method");
		this.message = message;
	}

	public void doWork() {
		
		System.out.println("doing work: "+ getMessage());
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method is called");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean  afterPropertiesSet is called");
	}


	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName: is called "+ name);
	}
}















