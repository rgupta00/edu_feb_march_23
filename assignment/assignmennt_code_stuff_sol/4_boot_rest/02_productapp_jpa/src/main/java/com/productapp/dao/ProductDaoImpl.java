package com.productapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.entity.Product;

@Service
@Transactional
public class ProductDaoImpl implements ProductDao {

	private EntityManager em;

	public ProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Product> getAll() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getById(Integer id) {
		return em.find(Product.class, id);
	}

	@Override
	public Product addProduct(Product product) {
		em.persist(product);
		return product;
	}

	@Override
	public Product deleteProduct(Integer id) {
		Product product = getById(id);
		em.remove(product);
		return product;
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setPrice(product.getPrice());
		em.merge(productToUpdate);
		return product;
	}

}
