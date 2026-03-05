package com.ecomm.product_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.product_service.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, String> {
   
}
