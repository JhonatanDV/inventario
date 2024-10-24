package com.example.inventory.domain.service;

import java.util.List;

import com.example.inventory.domain.dto.ProductStockDTO;

public interface InventoryService {
    List<ProductStockDTO> getAllProductStocks();
    void updateProductStock(Long productId, int stock);
    void reorderInventory(Long productId, int quantity);
}
