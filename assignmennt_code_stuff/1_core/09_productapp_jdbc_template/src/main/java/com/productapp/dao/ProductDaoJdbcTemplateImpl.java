package com.productapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ProductDaoJdbcTemplateImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getAll() {
		return jdbcTemplate.query("select * from product_table", new ProductRowMapper());
	}

	@Override
	public Product getById(Integer id) {
		return jdbcTemplate.queryForObject("select * from product_table where id=?", new ProductRowMapper(), id);
	}

	@Override
	public Product addProduct(Product product) {
		jdbcTemplate.update("insert into product_table(name, price, isAvailable) values(?,?,?)",
				new Object[] { product.getName(), product.getPrice(), product.isAvailable() });
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {

		jdbcTemplate.update("delete from product_table where id=?", id);

		return null;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		jdbcTemplate.update("update product_table set price =? ,isAvailable=? where id=?",
				new Object[] { product.getPrice(), product.isAvailable(), id });
		return product;
	}
}
