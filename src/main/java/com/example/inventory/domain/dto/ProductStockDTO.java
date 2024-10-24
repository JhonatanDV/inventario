package com.example.inventory.domain.dto;


public class ProductStockDTO {
    private Long productId;
    private int stock;

    // Constructor, getters y setters
    public ProductStockDTO(Long productId, int stock) {
        this.productId = productId;
        this.stock = stock;
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
}
