package com.example.inventory.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.inventory.infraestructure.crud_interface.InventoryCrudRepository;
import com.example.inventory.infraestructure.entities.ProductStock;
import com.example.inventory.domain.repository.InventoryRepositoryInterface;

@Repository
public class InventoryRepository implements InventoryRepositoryInterface {

    @Autowired
    private InventoryCrudRepository inventoryCrudRepository;

    @Override
    public List<ProductStock> getAllInventories() {
        return (List<ProductStock>) inventoryCrudRepository.findAll();
    }

    @Override
    public Optional<ProductStock> findById(Long id) {
        return inventoryCrudRepository.findById(id);
    }

    @Override
    public ProductStock createInventory(ProductStock productStock) {
        return inventoryCrudRepository.save(productStock);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryCrudRepository.deleteById(id);
    }

    @Override
    public List<ProductStock> findInventoriesByProductId(Long productId) {
        return inventoryCrudRepository.findByProductId(productId);
    }
}
