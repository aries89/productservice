package com.example.productservice.services.impl;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.dtos.ProductResponseDto;
import com.example.productservice.dtos.ProductUpdateDto;
import com.example.productservice.entities.Product;
import com.example.productservice.enums.ProductCategory;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.repos.ProductRepository;
import com.example.productservice.services.ProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductMapper productMapper;

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
		this.productMapper = productMapper;
		this.productRepository = productRepository;
	}

	@Override
	public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
		Product product = this.productRepository.save(this.productMapper.toEntity(productRequestDto));
		return this.productMapper.toDto(product);
	}

	@Override
	public ProductResponseDto updateProduct(Long id, ProductUpdateDto productUpdateDto) {
		Product productFromDb = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		this.productMapper.updateProductFromDto(productUpdateDto, productFromDb);
		return this.productMapper.toDto(productFromDb);
	}

	@Override
	public ProductResponseDto getProductById(Long id) {
		return this.productMapper
				.toDto(this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
	}

	@Override
	public List<ProductResponseDto> getAllProducts() {
		return this.productRepository.findAll().stream().map(p -> this.productMapper.toDto(p)).toList();
	}

	@Override
	public void deleteProduct(Long id) {
		if (this.productRepository.existsById(id)) {
			this.productRepository.deleteById(id);
		} else {
			throw new ProductNotFoundException(id);
		}
	}

	@Override
	public List<ProductResponseDto> getProductsByCategory(String category) {
		ProductCategory categoryFromEnum = ProductCategory.valueOf(category.toUpperCase());
		return this.productRepository.findByCategory(categoryFromEnum).stream()
				.map(p -> this.productMapper.toDto(p)).toList();
	}

	@Override
	public Page<ProductResponseDto> searchProductsByName(String productName,int page,int size,String sortBy,String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Product> products = this.productRepository.findByProductNameContainingIgnoreCase(productName,pageable);
		return products.map( p -> this.productMapper.toDto(p));
	}

	@Override
	public List<ProductResponseDto> getProductsByPriceRange(double minPrice, double maxPrice) {
		return this.productRepository.findByPriceBetween(minPrice, maxPrice).stream()
				.map(p -> this.productMapper.toDto(p)).toList();
	}

	@Override
	public void reduceStock(Long productId, Long quantity) {
		Product product = this.productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException(productId));
		if(quantity > product.getStockQuantity()) {
			throw new IllegalArgumentException("Insufficient stock");
		}
		product.setStockQuantity(product.getStockQuantity() - quantity);
		

	}

	@Override
	public boolean isProductAvailable(Long productId, Long quantity) {
		Product product = this.productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException(productId));
		return product.getStockQuantity() >= quantity;
	}

}
