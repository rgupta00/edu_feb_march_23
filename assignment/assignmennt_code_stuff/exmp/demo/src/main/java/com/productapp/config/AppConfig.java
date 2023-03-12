package com.productapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoImplJdbc;
import com.productapp.dao.ProductDaoImplMap;

@Configuration
@ComponentScan(basePackages = {"com.productapp"})
public class AppConfig {

	@Bean
	//@Profile("dev")
	@Conditional(MySQLTypeCondition.class)
	public ProductDao getProductDaoJdbc() {
		return new ProductDaoImplJdbc();
	}
	
	//@Profile("test")
	@Conditional(MongodbTypeCondition.class)
	@Bean
	public ProductDao getProductDaoMongo() {
		return new ProductDaoImplMap();
	}
	
}
