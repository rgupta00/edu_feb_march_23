package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "api")
public class ProductContoller {

	private ProductService productService;

	@Autowired
	public ProductContoller(ProductService productService) {
		this.productService = productService;
	}
	
	//ResponseEntity= Data + status code

	// --------get all products-----------
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}

	// --------get one product-----------
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getAnProductById(@PathVariable(name="id") int id) {
		return ResponseEntity.ok(productService.getById(id));
	}

	// -------add one product-----------
	@PostMapping(path = "products")
	public ResponseEntity<Product> addAnProduct(@RequestBody Product product) {
		Product productSaved= productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}
	
	//--------updated an product---------
	@PutMapping(path = "products/{id}")
	public ResponseEntity<Product> updateAnProduct(@PathVariable(name="id")int id,@RequestBody Product product ) {
		Product updatedProduct= productService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}
	
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(name="id")int id ) {
		 productService.deleteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
