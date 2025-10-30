package com.example.productservice.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.productservice.enums.ProductCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductResponseDto {

	
	private Long id;
	
	private String productName;
	
	private String description;
	
	private BigDecimal price;
	
	private Long stockQuantity;
	
	private ProductCategory category;
	
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	public ProductResponseDto() {
		
	}

	public ProductResponseDto(@NotNull Long id, @NotNull @NotBlank String productName,
			@NotNull @NotBlank String description, @NotNull BigDecimal price, @NotNull Long stockQuantity,
			@NotNull ProductCategory category, @NotNull LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.category = category;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
