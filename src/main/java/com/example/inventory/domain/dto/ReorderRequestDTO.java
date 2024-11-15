package com.example.inventory.domain.dto;

public class ReorderRequestDTO {
    private Long productId;
    private int quantity;  

    public ReorderRequestDTO(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters y setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
