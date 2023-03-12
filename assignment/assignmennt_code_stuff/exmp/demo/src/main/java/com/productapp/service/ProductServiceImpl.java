package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoImplMap;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao=new ProductDaoImplMap();

	@Override
	public List<String> getAll() {
		return productDao.getAll();
	}

}
