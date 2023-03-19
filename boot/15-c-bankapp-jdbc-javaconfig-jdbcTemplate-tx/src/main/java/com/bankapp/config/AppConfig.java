package com.bankapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bankapp.*" })
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@Import(DbMySQLConfig.class)
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
}
