package com.example.inventory.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.inventory.infraestructure.entities.ProductStock;

public interface InventoryRepositoryInterface {
    List<ProductStock> getAllInventories();
    Optional<ProductStock> findById(Long id);
    ProductStock createInventory(ProductStock productStock);
    void deleteInventory(Long id);
    List<ProductStock> findInventoriesByProductId(Long productId);
}
