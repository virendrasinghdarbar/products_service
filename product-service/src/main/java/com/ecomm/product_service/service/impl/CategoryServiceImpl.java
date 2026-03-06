package com.ecomm.product_service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ecomm.product_service.dto.CategoryRequestDto;
import com.ecomm.product_service.dto.CategoryResponseDto;
import com.ecomm.product_service.dto.ExtendedCategoryResponseDto;
import com.ecomm.product_service.entity.Category;
import com.ecomm.product_service.entity.Product;
import com.ecomm.product_service.mapper.CategoryMapping;
import com.ecomm.product_service.mapper.ProductMapping;
import com.ecomm.product_service.repository.CategoryRepository;
import com.ecomm.product_service.repository.ProductRepository;
import com.ecomm.product_service.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
 
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
   
   @Override
   public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setCategoryName(categoryRequestDto.getCategoryName());
        category.setDescription(categoryRequestDto.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapping.toCategoryResponseDto(savedCategory);
   }
   @Override
   public void deleteCategory(String catagotyId) {
        Category category = categoryRepository.findById(String.valueOf(catagotyId))
                            .orElseThrow(()-> new RuntimeException("Category not found"));
        if(!productRepository.findById(String.valueOf(catagotyId)).isEmpty()) {
            throw new RuntimeException("Cannot delete category with associated products");
        }
        categoryRepository.delete(category);   
   }

   @Override
   public List<ExtendedCategoryResponseDto> getAllCategories() {
         List<Category> categories = categoryRepository.findAll();
        List<ExtendedCategoryResponseDto> extendedCategoryResponseDtos = new ArrayList<>();
        for (Category category : categories) {
            ExtendedCategoryResponseDto extendedCategoryResponseDto = convertToExtendedDto(category);
            extendedCategoryResponseDtos.add(extendedCategoryResponseDto);
        }
         return extendedCategoryResponseDtos;     
        
   }
   @Override
   public CategoryResponseDto getCategoryById(String categoryId) {
        Category category = categoryRepository.findById(String.valueOf(categoryId))
                            .orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapping.toCategoryResponseDto(category);
   }
   @Override
   public CategoryResponseDto updateCategory(String categoryName, CategoryResponseDto categoryResponseDto) {
     
       return null;
   }

private ExtendedCategoryResponseDto convertToExtendedDto(Category category) {
   List<Product> products = category.getProducts();
   return new ExtendedCategoryResponseDto(
           category.getCategoryId(),
           category.getCategoryName(),
           category.getDescription(),
          products.stream().map(ProductMapping::toProductResponseDto).toList()
   );
    
}
}
