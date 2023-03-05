package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.entity.Product;
import com.productapp.exceptions.ProductNotFoundException;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl() {
	}

	@Autowired
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
		
		Product product= productDao.getById(id);
		if(product==null)
			throw new ProductNotFoundException("product not found");
		return product;
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
