package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.entity.Product;
import com.productapp.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	private Environment environment;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return productDao.findAll();
	}

	@Override
	public Product getById(Integer id) {
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(environment.getProperty("Service.PRODUCT_NOT_EXISTS")));
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product productToDelete = getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setPrice(product.getPrice());

		productDao.save(productToUpdate);

		return productToUpdate;
	}

}
