package com.productapp.controller;
import java.util.List;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;
public class Main {
	public static void main(String[] args) {

	
		ProductService productService=new ProductServiceImpl();
		List<Product>products=productService.getAll();
		
		products.forEach(p-> System.out.println(p));
	}

}
