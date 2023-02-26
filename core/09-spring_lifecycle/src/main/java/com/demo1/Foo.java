package com.demo1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo {

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

	@PreDestroy
	public void annoWalaDestroyMethod() {
		System.out.println("annoWalaDestroyMethod is called @PreDestroy");
	}

	public void setMessage(String message) {
		System.out.println("it is setter method");
		this.message = message;
	}

	public void doWork() {

		System.out.println("doing work: " + getMessage());
	}

}
