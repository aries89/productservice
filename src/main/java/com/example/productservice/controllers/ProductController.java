package com.example.productservice.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.dtos.ProductResponseDto;
import com.example.productservice.dtos.ProductUpdateDto;
import com.example.productservice.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;

	}

	@PostMapping
	public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
		ProductResponseDto productDto = this.productService.createProduct(productRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id,
			@Valid @RequestBody ProductUpdateDto productUpdateDto) {
		ProductResponseDto productDto = this.productService.updateProduct(id, productUpdateDto);
		return ResponseEntity.status(HttpStatus.OK).body(productDto);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.getProductById(id));
	}

	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.getAllProducts());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		this.productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<ProductResponseDto>> getProductsByCategory(@PathVariable String category) {
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.getProductsByCategory(category));
	}

	@GetMapping("/search")
	public ResponseEntity<Page<ProductResponseDto>> searchProductsByName(@RequestParam String name,
			@RequestParam int page, @RequestParam int size, @RequestParam String sortBy,
			@RequestParam String sortDir) {
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.searchProductsByName(name,page,size,sortBy,sortDir));
	}

	@GetMapping("/price-range")
	public ResponseEntity<List<ProductResponseDto>> getProductsByPriceRange(@RequestParam double minPrice,
			@RequestParam double maxPrice) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.productService.getProductsByPriceRange(minPrice, maxPrice));

	}

	@PutMapping("/{id}/reduce-stock")
	public ResponseEntity<Void> reduceStock(@PathVariable Long id, @RequestParam Long quantity) {
		this.productService.reduceStock(id, quantity);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@GetMapping("/{id}/available")
	public ResponseEntity<Boolean> isProductAvailable(@PathVariable Long id, @RequestParam Long quantity) {
		return ResponseEntity.status(HttpStatus.OK).body(this.productService.isProductAvailable(id, quantity));
	}

}
