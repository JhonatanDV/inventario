package com.example.inventory.infraestructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "StockUpdates")
public class StockUpdateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StockUpdate_ID")
    private Long stockUpdateId;

    @Column(nullable = false)
    private int stock;

    // Getters y Setters
    public Long getStockUpdateId() {
        return stockUpdateId;
    }

    public void setStockUpdateId(Long stockUpdateId) {
        this.stockUpdateId = stockUpdateId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
