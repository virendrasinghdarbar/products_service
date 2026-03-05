package com.ecomm.product_service.config;


public class IdGenerator {
    private static int productIdCounter = 0;
    private static int categoryIdCounter = 0; 

    public static synchronized int generateProductId() {
         productIdCounter++;
         return productIdCounter;
    }

    public static synchronized int generateCategoryId() {
         categoryIdCounter++;
         return categoryIdCounter;
    }
}
