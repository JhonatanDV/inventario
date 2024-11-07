package com.example.inventory.domain.dto;

public class StockUpdateRequestDTO {

    private int stock;

    // Constructor sin parámetros (necesario para la deserialización automática de Spring)
    public StockUpdateRequestDTO() {
    }

    // Constructor con parámetros (opcional, si necesitas inicializar el objeto directamente)
    public StockUpdateRequestDTO(int stock) {
        this.stock = stock;
    }

    // Getters y setters
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
