package com.ecomm.product_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.product_service.dto.ProductRequestDto;
import com.ecomm.product_service.dto.ProductResponseDto;
import com.ecomm.product_service.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);   
    }

    @GetMapping(value = "/{productId}")
    public ProductResponseDto getProductById(@PathVariable String productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping(value = "/{productId}")
    public ProductResponseDto updateProduct(@PathVariable String productId, @RequestBody Integer stockQuantity) {
        return productService.updateProduct(productId, stockQuantity);
    }

    @DeleteMapping(value = "/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return "Product with ID " + productId + " has been deleted successfully.";
    }

}
