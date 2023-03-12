package com.productapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoJdbcImpl;
import com.productapp.dao.ProductDaoMapImpl;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.productapp.*"})
@Scope(value = "singleton")
public class AppConfig {

	
	@Bean(name = "productService")
	public ProductService getProductService(ProductDao productDao) {
		ProductService productService=new ProductServiceImpl(productDao);
		return productService;
	}
	
	@Bean
	public ProductDao getProductDaoMap() {
		ProductDao dao=new ProductDaoMapImpl();
		return dao;
	}
	
	@Primary
	@Bean
	public ProductDao getProductDaoJdbc() {
		ProductDao dao=new ProductDaoJdbcImpl();
		return dao;
	}
}



