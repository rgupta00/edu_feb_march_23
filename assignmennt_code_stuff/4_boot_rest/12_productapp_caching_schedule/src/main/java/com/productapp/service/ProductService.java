package com.productapp.service;

import java.util.List;

import com.productapp.entity.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getById(Integer id );
	public Product addProduct(Product product);
	public Product deleteProduct(Integer id );
	public Product updateProduct(Integer id, Product product );
	public void evictCache();
}
