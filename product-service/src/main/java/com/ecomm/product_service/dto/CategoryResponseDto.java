package com.ecomm.product_service.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private String categoryId;
    private String categoryName;
    private String description;
}
