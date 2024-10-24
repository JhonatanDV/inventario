package com.example.inventory.domain.service;

import java.util.List;

import com.example.inventory.domain.dto.ProductStock;

public interface InventoryService {
    List<ProductStock> getAllProductStocks();
    void updateProductStock(Long productId, int stock);
    void reorderInventory(Long productId, int quantity);
}
