package com.example.spring_boot_API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_API.entity.Product;
import com.example.spring_boot_API.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService= productService;
	}
	
	// To create e new product
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		Product newProduct = productService.saveProduct(product);
		return ResponseEntity.ok(newProduct);
	}
	
	// Get all the products
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		System.out.println("all produts list");
		return productService.getAllProducts();
	}
	
	// Get a product by ID
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id)
	{
		Optional<Product> product=productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	//Update a product by ID 
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product)
	{
		Product updatedProduct = productService.updateProduct(id, product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	//Delete a product by ID
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id)
	{
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted Successfully");
	}
	
	
}
