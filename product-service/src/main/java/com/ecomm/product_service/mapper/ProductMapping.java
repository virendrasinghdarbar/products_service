package com.ecomm.product_service.mapper;

import com.ecomm.product_service.dto.ProductResponseDto;
import com.ecomm.product_service.entity.Product;

public class ProductMapping {
    
    public static ProductResponseDto toProductResponseDto(Product poduct) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setProductId(String.valueOf(poduct.getProductId()));
        responseDto.setName(poduct.getName());
        responseDto.setDescription(poduct.getDescription());
        responseDto.setPrice(poduct.getPrice());
        responseDto.setStockQuantity(poduct.getStockQuantity());
        responseDto.setInStock(poduct.getStockQuantity() > 0);
        responseDto.setCategoryName(poduct.getCategory().getCategoryName());
        return responseDto;
    }

    public static Product toProductEntity(ProductResponseDto responseDto) {
        Product product = new Product();
        product.setProductId(responseDto.getProductId());
        product.setName(responseDto.getName());
        product.setDescription(responseDto.getDescription());
        product.setPrice(responseDto.getPrice());
        product.setStockQuantity(responseDto.getStockQuantity());
        // Category mapping would require fetching the Category entity based on categoryName
        return product;
    }
}
