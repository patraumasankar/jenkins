package com.wipro.rolebasedjwt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productid;
	private String title;
	private String description;
	private Integer price;
	private Double discount;
	private Double rating;
	private Integer stock;
	private String brand;
	private String category;
	private String thumbnail;
	
}
