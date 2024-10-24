package com.example.inventory.domain.service.impl;

import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.infraestructure.repositories.ProductRepository;
import com.example.inventory.domain.service.InventoryService;
import com.example.inventory.infraestructure.mapper.ProductStockMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public List<ProductStockDTO> getAllProductStocks() {
        // Usar el mapper para convertir las entidades en DTOs
        List<com.example.inventory.infraestructure.entities.ProductStock> productEntityList = productRepository.getAllProducts();
        return productStockMapper.ProductStock(productEntityList);  // Convertir entidades a DTOs
    }

    @Override
    public void updateProductStock(Long productId, int stock) {
        Optional<com.example.inventory.infraestructure.entities.ProductStock> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            com.example.inventory.infraestructure.entities.ProductStock product = optionalProduct.get();
            product.setStock(stock); // Actualizar el stock
            productRepository.save(product); // Guardar el producto actualizado
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void reorderInventory(Long productId, int quantity) {
        // Lógica para reordenar inventario
    }
}
