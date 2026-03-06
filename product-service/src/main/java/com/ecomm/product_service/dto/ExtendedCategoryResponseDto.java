package com.ecomm.product_service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedCategoryResponseDto extends CategoryResponseDto {
     List<ProductResponseDto> products;
     public ExtendedCategoryResponseDto(String categoryId, String categoryName, String description, List<ProductResponseDto> products) {
        super(categoryId, categoryName, description);
        this.products = products;
     }
}
