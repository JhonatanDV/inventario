package com.example.inventory.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.inventory.domain.dto.ProductStock;
import com.example.inventory.infraestructure.crud_interface.InventoryCrudRepository;
import com.example.inventory.infraestructure.entities.Product;
import com.example.inventory.infraestructure.mapper.ProductStockMapper;
import com.example.inventory.domain.repository.InventoryRepositoryInterface;


@Repository
public class InventoryRepository implements InventoryRepositoryInterface {

    @Autowired
    private InventoryCrudRepository inventoryCrudRepository;

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public List<ProductStock> getAllInventories() {
        List<Product> products = (List<Product>) inventoryCrudRepository.findAll();
        return productStockMapper.toProductStocks(products);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return inventoryCrudRepository.findById(id);
    }

    @Override
    public ProductStock createInventory(ProductStock productStock) {
        Product product = productStockMapper.toProduct(productStock);
        product = inventoryCrudRepository.save(product);
        return productStockMapper.toProductStock(product);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryCrudRepository.deleteById(id);
    }

    @Override
    public List<ProductStock> findInventoriesByProductId(Long productId) {
        List<Product> products = inventoryCrudRepository.findByProductId(productId);
        return productStockMapper.toProductStocks(products);
    }
}
