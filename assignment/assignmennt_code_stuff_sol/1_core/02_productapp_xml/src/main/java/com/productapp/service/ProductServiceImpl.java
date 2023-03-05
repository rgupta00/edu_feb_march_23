package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoMapImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	
	
	public ProductServiceImpl() {}

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll().stream().filter(p->p.isAvailable()).collect(Collectors.toList());
	}

	@Override
	public Product getById(Integer id) {
		return productDao.getById(id);
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public Product deleteProduct(Integer id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		return productDao.updateProduct(id, product);
	}

}
