package com.productapp.service;

import java.lang.reflect.Proxy;

public class Demo {

	public static void main(String[] args) {
		Product product=new Product(1, "laptop", 120);
		ProductService productService=new ProductServiceImpl();
		
		ProductServiceInvocationHandler handler=new ProductServiceInvocationHandler(productService);
		
		ProductService productServiceProxy=(ProductService) Proxy.newProxyInstance
				(ProductServiceImpl.class.getClassLoader(), new Class[] {ProductService.class}, handler);
		
		Product addProduct = productServiceProxy.addProduct(product);
		System.out.println(addProduct);
		
	}
}
