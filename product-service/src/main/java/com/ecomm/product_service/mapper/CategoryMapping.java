package com.ecomm.product_service.mapper;

import com.ecomm.product_service.dto.CategoryResponseDto;
import com.ecomm.product_service.entity.Category;


public class CategoryMapping {
    public static CategoryResponseDto toCategoryResponseDto(Category category) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setCategoryId(category.getCategoryId());
        responseDto.setCategoryName(category.getCategoryName());
        responseDto.setDescription(category.getDescription());
        return responseDto;
    }
   
    public static Category toCategoryEntity(CategoryResponseDto responseDto) {
        Category category = new Category();
        category.setCategoryName(responseDto.getCategoryName());
        category.setDescription(responseDto.getDescription());
        return category;
    }
}
