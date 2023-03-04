package com.productapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.productapp" })
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@Import(DataSourceConfig.class)
public class AppConfig {

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
		lsfb.setPackagesToScan(new String[] {"com.productapp.entity"});
		lsfb.setDataSource(dataSource);
		lsfb.setHibernateProperties( getHibernateProperties());
		return lsfb;
	}
	
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		
		return null;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager dsTx = new HibernateTransactionManager();
		dsTx.setSessionFactory(sessionFactory);
		return dsTx;
	}
}
