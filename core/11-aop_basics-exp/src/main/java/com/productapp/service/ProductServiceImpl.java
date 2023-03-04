package com.productapp.service;

public class ProductServiceImpl implements ProductService {
	@Override
	public Product addProduct(Product product) {
		System.out.println("added to db");//add to db
		return product;
	}
}
