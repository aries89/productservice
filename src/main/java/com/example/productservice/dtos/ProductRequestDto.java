package com.example.productservice.dtos;

import java.math.BigDecimal;
import com.example.productservice.enums.ProductCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDto {
	
	@NotNull
	@NotBlank
	private String productName;

	@NotNull
	@NotBlank
	private String description;

	@NotNull
	private BigDecimal price;

	@NotNull
	private Long stockQuantity;

	@NotNull
	private ProductCategory category;
	
	public ProductRequestDto() {
		
	}

	public ProductRequestDto(String productName, String description, BigDecimal price, Long stockQuantity,
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
