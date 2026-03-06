package com.ecomm.product_service.entity;

import java.time.LocalDateTime;

import com.ecomm.product_service.config.IdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    private String name;
    private String description;
    private double price;
    private Integer stockQuantity;
    private boolean inStock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;


    @PrePersist
    @PreUpdate
    public void updateStockStatus() {
        this.inStock = this.stockQuantity != null && this.stockQuantity > 0;
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();

        if(this.productId == null) {
        this.productId = "Pro_" + String.format("%05d", IdGenerator.generateProductId());
        }
    }
    
}
