package com.ecomm.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.product_service.dto.CategoryRequestDto;
import com.ecomm.product_service.dto.CategoryResponseDto;
import com.ecomm.product_service.dto.ExtendedCategoryResponseDto;

@Service  
public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto getCategoryById(String categoryId);
    CategoryResponseDto updateCategory(String categoryName, CategoryResponseDto categoryResponseDto);
    void deleteCategory(String catagotyId);
    List<ExtendedCategoryResponseDto> getAllCategories();

}
