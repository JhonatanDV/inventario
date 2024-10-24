package com.example.inventory.domain.dto;

public class StockUpdateRequest {
    private int stock;

    // Constructor, getters y setters
    public StockUpdateRequest(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
