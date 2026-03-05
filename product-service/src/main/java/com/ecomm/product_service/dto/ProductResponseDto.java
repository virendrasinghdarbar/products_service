package com.ecomm.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private String productId;
    private String name;
    private String description;
    private double price;
    private Integer stockQuantity;
    private boolean inStock;
    private String categoryName;

    
}
