package com.example.inventory.domain.dto;

import java.time.LocalDateTime;

public class ProductStockDTO {
    private Long productId;
    private int stock;
    private String productname;  
    private LocalDateTime lastUpdated;  

    // Constructor, getters y setters
    public ProductStockDTO(Long productId, int stock, String productname, LocalDateTime lastUpdated) {
        this.productId = productId;
        this.stock = stock;
        this.productname = productname;
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

    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
