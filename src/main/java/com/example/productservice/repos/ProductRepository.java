package com.example.productservice.repos;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.entities.Product;
import com.example.productservice.enums.ProductCategory;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByCategory(ProductCategory category);
	
	public Page<Product> findByProductNameContainingIgnoreCase(String productName,Pageable page);
	
	public List<Product> findByPriceBetween(double minPrice, double maxPrice);

}
