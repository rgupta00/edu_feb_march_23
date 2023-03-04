package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "api")
public class ProductContoller {

	private ProductService productService;

	@Autowired
	public ProductContoller(ProductService productService) {
		this.productService = productService;
	}

	// --------get all products-----------
	@GetMapping(path = "products")
	public List<Product> getAll() {
		return productService.getAll();
	}

	// --------get one product-----------
	@GetMapping(path = "products/{id}")
	public Product getAnProductById(@PathVariable(name="id") int id) {
		return productService.getById(id);
	}

	// -------add one product-----------
	@PostMapping(path = "products")
	public Product addAnProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	//--------updated an product---------
	@PutMapping(path = "products/{id}")
	public Product updateAnProduct(@PathVariable(name="id")int id,@RequestBody Product product ) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping(path = "products/{id}")
	public Product deleteAnProduct(@PathVariable(name="id")int id ) {
		return productService.deleteProduct(id);
	}
	
}
