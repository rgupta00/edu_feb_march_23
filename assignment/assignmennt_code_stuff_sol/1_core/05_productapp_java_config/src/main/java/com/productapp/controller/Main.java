package com.productapp.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.config.ProductConfig;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;

import java.util.*;
public class Main {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(ProductConfig.class);
		

		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		
		List<Product> productList=productService.getAll();
		
		productList.forEach(p-> System.out.println(p));
		
	}

}
