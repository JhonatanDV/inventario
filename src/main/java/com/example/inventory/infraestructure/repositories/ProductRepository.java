package com.example.inventory.infraestructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.inventory.infraestructure.crud_interface.InventoryCrudRepository;
import com.example.inventory.infraestructure.entities.ProductStock;
import com.example.inventory.infraestructure.mapper.ProductStockMapper;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    private InventoryCrudRepository productCrudRepository;

    @Autowired
    @SuppressWarnings("unused")
    private ProductStockMapper productMapper;

    public List<ProductStock> getAllProducts() {
        return (List<ProductStock>) productCrudRepository.findAll();
    }

    public Optional<ProductStock> findById(Long id) {
        return productCrudRepository.findById(id);
    }

    public ProductStock save(ProductStock product) {
        return productCrudRepository.save(product);
    }

    public void deleteById(Long id) {
        productCrudRepository.deleteById(id);
    }
}
