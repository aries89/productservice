package com.example.productservice.dtos;

import java.math.BigDecimal;

import com.example.productservice.enums.ProductCategory;

public class ProductUpdateDto {

	
	
	private String productName;

	private String description;

	private BigDecimal price;

	private Long stockQuantity;

	private ProductCategory category;
	
	public ProductUpdateDto() {
		
	}

	public ProductUpdateDto(String productName, String description, BigDecimal price, Long stockQuantity,
			ProductCategory category) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	



}
