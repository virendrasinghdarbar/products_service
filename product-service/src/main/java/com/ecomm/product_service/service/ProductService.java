package com.ecomm.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.product_service.dto.ProductRequestDto;
import com.ecomm.product_service.dto.ProductResponseDto;

@Service
public interface ProductService {
  
    ProductResponseDto getProductById(String productId);
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto updateProduct(String productId, Integer stockQuantity);
    List<ProductResponseDto> getAllProducts();
    String deleteProduct(String productId);
}

