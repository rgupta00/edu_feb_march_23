package com.productapp.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductServiceInvocationHandler implements InvocationHandler {
	//target object
	private ProductService productServiceTarget;//will get implementation

	public ProductServiceInvocationHandler(ProductService productServiceTarget) {
		this.productServiceTarget = productServiceTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("pre processng logic");//pre processing logic
		//invoking actual actual logic
		Object result=method.invoke(productServiceTarget , args);
		//return the value to the called method
		return result;
	}
}
