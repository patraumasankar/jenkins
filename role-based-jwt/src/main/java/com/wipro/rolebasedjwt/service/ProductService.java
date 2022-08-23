package com.wipro.rolebasedjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.rolebasedjwt.model.Product;
import com.wipro.rolebasedjwt.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepository;	

	public List<Product> getAllProducts() {
		return productrepository.findAll();
	}

	public Product addProduct(Product product) {
		return productrepository.save(product);
	}
	
	public Product getProductById(Long Id) {
		return productrepository.findByProductid(Id);
	}
	
	public Product deldeteProduct(Long Id) {
		Product product = getProductById(Id);
		productrepository.delete(product);
		return product;
	}
	
	public Product updateProduct(Product product,Long Id) {
		Product updateProduct = getProductById(Id);
		updateProduct.setTitle(product.getTitle());
		updateProduct.setBrand(product.getBrand());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setThumbnail(product.getThumbnail());
		updateProduct.setCategory(product.getCategory());
		updateProduct.setPrice(product.getPrice());
		updateProduct.setDiscount(product.getDiscount());
		updateProduct.setRating(product.getRating());
		updateProduct.setStock(product.getStock());
		return productrepository.save(updateProduct);
	}
	
	
	
}
