package com.example.inventory.infraestructure.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Products")
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ID")
    private Long productId;

    @Column(nullable = false, length = 100)
    private String productname;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
private Date lastUpdated;

    // Getters y Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
