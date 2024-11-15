package com.example.inventory.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.inventory.domain.dto.ProductStockDTO;

public interface InventoryRepositoryInterface {
    List<ProductStockDTO> getAllInventories();
    Optional<ProductStockDTO> findById(Long id);
    ProductStockDTO createInventory(ProductStockDTO productStock);
    void deleteInventory(Long id);
    List<ProductStockDTO> findInventoriesByProductId(Long productId);
}
