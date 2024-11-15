package com.example.inventory.infraestructure.crud_interface;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.infraestructure.entities.ProductStock;

import java.util.List;

public interface InventoryCrudRepository extends CrudRepository<ProductStock, Long> {
    List<ProductStock> findByProductId(Long productId);
}
