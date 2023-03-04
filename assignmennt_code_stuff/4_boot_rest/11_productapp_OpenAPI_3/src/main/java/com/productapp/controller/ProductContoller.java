package com.productapp.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
	
	@Tag(name="Product management application")
	@RestController
	@RequestMapping(path = "api")
	public class ProductContoller {
	
		private ProductService productService;
	
		@Autowired
		public ProductContoller(ProductService productService) {
			this.productService = productService;
		}
	
		// ResponseEntity= Data + status code
	
		// --------get all products-----------
		@Operation(summary = "getting all products")
		@GetMapping(path = "products")
		public ResponseEntity<List<Product>> getAll() {
			return ResponseEntity.ok(productService.getAll());
		}
	
		// --------get one product-----------
		@Operation(summary = "getting an product by passing valid id")
		@GetMapping(path = "products/{id}")
		public ResponseEntity<Product> getAnProductById(@Parameter(description = "Product Id need to pass", required = true)
				@PathVariable(name = "id") int id) {
			return ResponseEntity.ok(productService.getById(id));
		}
		
		// -------add one product-----------
		@Operation(summary = "getting an product by passing valid id")
		@ApiResponses(value = {
				@ApiResponse(responseCode ="500", description = "Internal server error"),
				@ApiResponse(responseCode ="400", description = "Validation error")
				})
		@PostMapping(path = "products")
		public ResponseEntity<Product> addAnProduct(@Valid @RequestBody ProductDto productDto) {
			Product product = convertToProduct(productDto);
	
			Product productSaved = productService.addProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
		}
	
		private Product convertToProduct(ProductDto productDto) {
			Product product = new Product();
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			return product;
		}
	
		private ProductDto convertToProductDto(Product product) {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setPrice(product.getPrice());
			return productDto;
		}
		
		
		// --------updated an product---------
		@PutMapping(path = "products/{id}")
		public ResponseEntity<Product> updateAnProduct(@PathVariable(name = "id") int id,
				@RequestBody Product product) {
			Product updatedProduct = productService.updateProduct(id, product);
			return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
		}
	
		@DeleteMapping(path = "products/{id}")
		public ResponseEntity<Void> deleteAnProduct(@PathVariable(name = "id") int id) {
			productService.deleteProduct(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	
	}
