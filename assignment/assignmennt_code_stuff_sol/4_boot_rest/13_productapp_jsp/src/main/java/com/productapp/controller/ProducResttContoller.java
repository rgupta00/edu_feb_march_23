package com.productapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import com.productapp.dao.ProductDao;
import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "api")
public class ProducResttContoller {

	private ProductService productService;

	@Autowired
	private Environment environment;
	
	@Autowired
	public ProducResttContoller(ProductService productService) {
		this.productService = productService;
	}

	// ResponseEntity= Data + status code

	// --------get all products-----------
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}

	// --------get one product-----------
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getAnProductById(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(productService.getById(id));
	}

	// -------add one product-----------
	@PostMapping(path = "products")
	public ResponseEntity<String> addAnProduct(@Valid @RequestBody ProductDto productDto) {
		Product product = convertToProduct(productDto);

		String ADD_MESSAGE = environment.getProperty("UserInterface.PRODUCT_CREATED_SUCCESS");

		Product productSaved = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(ADD_MESSAGE);
	}

	// --------updated an product---------
	@PutMapping(path = "products/{id}")
	public ResponseEntity<String> updateAnProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);

		String UPDATE_MESSAGE = environment.getProperty("UserInterface.PRODUCT_UPDATED_SUCCESS");
		
		return ResponseEntity.status(HttpStatus.OK).body(UPDATE_MESSAGE);
	}

	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<String> deleteAnProduct(@PathVariable(name = "id") int id) {
		productService.deleteProduct(id);

		String DELETE_MESSAGE = environment.getProperty("UserInterface.PRODUCT_DELETE_SUCCESS");
		
		return ResponseEntity.status(HttpStatus.OK).body(DELETE_MESSAGE);
	}

	private Product convertToProduct(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		return product;
	}

}
