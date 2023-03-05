package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.entity.Product;
import com.productapp.exceptions.ProductNotFoundException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
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

	@Cacheable(value="products", key = "#id")
	@Override
	public Product getById(Integer id) {
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(environment.getProperty("Service.PRODUCT_NOT_EXISTS")));
	}

	@CachePut(value="products", key="#result.id")
	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@CacheEvict(value="products", key="#id")
	@Override
	public Product deleteProduct(Integer id) {
		Product productToDelete = getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

	@CachePut(value="products", key="#result.id")
	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setPrice(product.getPrice());

		productDao.save(productToUpdate);

		return productToUpdate;
	}
	
	@CacheEvict(value="products", allEntries=true)
	@Override
	public void evictCache() {
		log.info("*********************888cache is cleared****************");
	}

}
