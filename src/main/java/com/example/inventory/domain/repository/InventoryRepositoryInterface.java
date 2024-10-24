package com.example.inventory.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.inventory.domain.dto.ProductStock;
import com.example.inventory.infraestructure.entities.Product;

public interface InventoryRepositoryInterface {
    List<ProductStock> getAllInventories();
    Optional<Product> findById(Long id);
    ProductStock createInventory(ProductStock productStock);
    void deleteInventory(Long id);
    List<ProductStock> findInventoriesByProductId(Long productId);
}
