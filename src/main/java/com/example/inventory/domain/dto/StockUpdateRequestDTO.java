package com.example.inventory.domain.dto;

public class StockUpdateRequestDTO {
    private int stock;

    // Constructor, getters y setters
    public StockUpdateRequestDTO(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
