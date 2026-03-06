package com.ecomm.product_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.product_service.dto.CategoryRequestDto;
import com.ecomm.product_service.dto.CategoryResponseDto;
import com.ecomm.product_service.dto.ExtendedCategoryResponseDto;
import com.ecomm.product_service.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        System.out.println(categoryRequestDto.getCategoryName()+" "+categoryRequestDto.getDescription());
        return categoryService.createCategory(categoryRequestDto);
    }

    @GetMapping(value = "/{categoryId}")
    public CategoryResponseDto getCategoryById(@PathVariable String categoryId) {
        return categoryService.getCategoryById(categoryId);
     }

     @GetMapping("/all")
     public List<ExtendedCategoryResponseDto> getAllCategories() {
        List<ExtendedCategoryResponseDto> extendedCategoryResponseDtos = categoryService.getAllCategories();
         return extendedCategoryResponseDtos;
     }
    
     @DeleteMapping(value = "/{categoryId}")
    public String deleteCategory(@PathVariable String categoryId) {
            categoryService.deleteCategory(categoryId);
            return "Category with ID " + categoryId + " has been deleted successfully.";
        }
}
