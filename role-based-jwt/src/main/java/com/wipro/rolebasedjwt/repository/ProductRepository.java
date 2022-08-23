package com.wipro.rolebasedjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rolebasedjwt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Product findByProductid(Long productid);
}

