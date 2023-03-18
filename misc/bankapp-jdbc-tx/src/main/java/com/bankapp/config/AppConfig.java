package com.bankapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bankapp.*" })
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/edum", "root", "root");
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public TransactionManager getDataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
