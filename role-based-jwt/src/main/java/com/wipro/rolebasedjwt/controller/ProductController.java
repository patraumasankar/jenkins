package com.wipro.rolebasedjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rolebasedjwt.model.Product;
import com.wipro.rolebasedjwt.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/getall")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/get/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable Long id) {
		return productService.updateProduct(product, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		Product product = productService.deldeteProduct(id);
		return product;
	}
}
