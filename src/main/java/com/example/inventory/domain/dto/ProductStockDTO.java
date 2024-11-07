package com.example.inventory.domain.dto;

import java.time.LocalDateTime;

public class ProductStockDTO {
    private Long productId;
    private int stock;
    private String productName;  
    private LocalDateTime lastUpdated;  

    // Constructor, getters y setters
    public ProductStockDTO(Long productId, int stock, String productName, LocalDateTime lastUpdated) {
        this.productId = productId;
        this.stock = stock;
        this.productName = productName;
        this.lastUpdated = lastUpdated;  
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
