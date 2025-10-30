package com.example.productservice.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.dtos.ProductResponseDto;
import com.example.productservice.dtos.ProductUpdateDto;

public interface ProductService {
	
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductUpdateDto productUpdateDto);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProducts();

    void deleteProduct(Long id);

    List<ProductResponseDto> getProductsByCategory(String category);

    Page<ProductResponseDto> searchProductsByName(String productName,int page,int size,String sortBy,String sortDir);

    List<ProductResponseDto> getProductsByPriceRange(double minPrice, double maxPrice);

    void reduceStock(Long productId, Long quantity);

    boolean isProductAvailable(Long productId, Long quantity);

}
