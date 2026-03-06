package com.ecomm.product_service.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ecomm.product_service.dto.ProductRequestDto;
import com.ecomm.product_service.dto.ProductResponseDto;
import com.ecomm.product_service.entity.Category;
import com.ecomm.product_service.entity.Product;
import com.ecomm.product_service.repository.CategoryRepository;
import com.ecomm.product_service.repository.ProductRepository;
import com.ecomm.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
        @Override
        public ProductResponseDto getProductById(String productId) {
            Product product = productRepository.findById(String.valueOf(productId))
                            .orElseThrow(()-> new RuntimeException("Product not found"));  
            return convertToDto(product);
        }
    
        @Override
        public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
           Category category = categoryRepository.findById(String.valueOf(productRequestDto.getCategoryId()))
                           .orElseThrow(()-> new RuntimeException("Category not found"));

          Product product=new Product();
            product.setName(productRequestDto.getName());
            product.setDescription(productRequestDto.getDescription());
            product.setPrice(productRequestDto.getPrice());
            product.setStockQuantity(productRequestDto.getStockQuantity());
            product.setCategory(category);
            Product savedProduct = productRepository.save(product);
            ProductResponseDto productResponseDto = convertToDto(savedProduct);
            return productResponseDto;
        }

        @Override
        public ProductResponseDto updateProduct(String productId, Integer stockQuantity) {
           Product product = productRepository.findById(String.valueOf(productId))
                            .orElseThrow(()-> new RuntimeException("Product not found"));
            product.setStockQuantity(stockQuantity);
            Product updatedProduct = productRepository.save(product);
            return convertToDto(updatedProduct);
        }
    
        @Override
        public List<ProductResponseDto> getAllProducts() {
            List<Product> products = productRepository.findAll();
            return products.stream()
                    .map(this::convertToDto)
                    .toList();
        }

        @Override
        public String deleteProduct(String productId) {
            Product product = productRepository.findById(String.valueOf(productId))
                            .orElseThrow(()-> new RuntimeException("Product not found"));  
                if(!productRepository.findById(String.valueOf(productId)).isEmpty()) {
                    throw new RuntimeException("Cannot delete product with associated orders");
                }
              productRepository.delete(product);
              return "Product "+productId+" deleted successfully";
        }

        private ProductResponseDto convertToDto(Product product) {
            ProductResponseDto dto = new ProductResponseDto();
            dto.setProductId(String.valueOf(product.getProductId()));
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setStockQuantity(product.getStockQuantity());
            dto.setInStock(product.isInStock());
            dto.setCategoryName(product.getCategory().getCategoryName());
            return dto;
        }
}
