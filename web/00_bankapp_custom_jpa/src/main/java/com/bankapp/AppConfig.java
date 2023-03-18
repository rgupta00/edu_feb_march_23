package com.bankapp;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = "com.bankapp.repo", 
	entityManagerFactoryRef = "db1EntityManagerFactory",
	transactionManagerRef = "db1TransactionManager")
public class AppConfig {
	
	@Autowired
	private Environment env;

	@Bean
	@ConfigurationProperties(prefix = "datasource.db1")
	public DataSourceProperties db1DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource db1DataSource() {
		
		DataSourceProperties db1DataSourceProperties = db1DataSourceProperties();
		
		return DataSourceBuilder.create()
				.driverClassName(db1DataSourceProperties.getDriverClassName())
				.url(db1DataSourceProperties.getUrl())
				.username(db1DataSourceProperties.getUsername())
				.password(db1DataSourceProperties.getPassword()).build();
	}

	@Bean
	public PlatformTransactionManager db1TransactionManager() {
		EntityManagerFactory factory = db1EntityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(db1DataSource());
		factory.setPackagesToScan(new String[] { "com.bankapp.entities" });
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
		factory.setJpaProperties(jpaProperties);

		return factory;
	}
}
