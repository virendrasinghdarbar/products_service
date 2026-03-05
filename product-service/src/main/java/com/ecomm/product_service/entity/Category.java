package com.ecomm.product_service.entity;

import java.util.List;

import com.ecomm.product_service.config.IdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryId;
    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    @PrePersist
    public void generateCategoryId() {
        if(this.categoryId == null) {
        this.categoryId ="Cat_" + String.format("%05d", IdGenerator.generateCategoryId());
        }
    }
}
