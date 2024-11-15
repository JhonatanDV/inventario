package com.example.inventory.infraestructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Reorders")
public class ReorderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reorder_ID")
    private Long reorderId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

    // Getters y Setters
    public Long getReorderId() {
        return reorderId;
    }

    public void setReorderId(Long reorderId) {
        this.reorderId = reorderId;
    }

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
