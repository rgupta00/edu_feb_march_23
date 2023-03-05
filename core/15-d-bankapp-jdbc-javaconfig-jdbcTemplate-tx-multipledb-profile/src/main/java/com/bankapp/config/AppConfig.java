package com.bankapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bankapp.*" })
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:db.properties")

public class AppConfig {

	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager dsTxMgr = new DataSourceTransactionManager();
		dsTxMgr.setDataSource(dataSource);
		return dsTxMgr;
	}
	

	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driver}")
	private String driverName;

	@Bean
	@Profile("test")
	public DriverManagerDataSource getDriverManagerDataSourceMySql() {
		System.out.println("test profile");
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setDriverClassName(driverName);
		return ds;
	}
	
	@Profile("dev")
	@Bean
	public DriverManagerDataSource getDriverManagerDataSourceH2() {
		System.out.println("dev profile");
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setUrl(url);
		ds.setDriverClassName(driverName);
		return ds;
	}
	
}
