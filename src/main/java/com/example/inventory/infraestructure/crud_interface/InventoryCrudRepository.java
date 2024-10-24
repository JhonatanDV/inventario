package com.example.inventory.infraestructure.crud_interface;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.infraestructure.entities.Product;

import java.util.List;

public interface InventoryCrudRepository extends CrudRepository<Product, Long> {
    List<Product> findByProductId(Long productId);
}
