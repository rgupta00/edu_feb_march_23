package com.productapp.dao;

import java.util.List;

import javax.sound.sampled.Port;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.entity.Product;
import com.productapp.exceptions.ProductNotFoundException;
@Service
@Transactional
public class ProductDaoImpl implements ProductDao{

	private SessionFactory sessionFactory;

	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Product> getAll() {
		return getSession().createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getById(Integer id) {
		return getSession().find(Product.class, id);
	}

	@Override
	public Product addProduct(Product product) {
		getSession().save(product);
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product product=getById(id);
		getSession().delete(product);
		return product;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate=getById(id);
		productToUpdate.setAvailable(product.isAvailable());
		productToUpdate.setPrice(product.getPrice());
		getSession().merge(productToUpdate);
		return product;
	}

}
