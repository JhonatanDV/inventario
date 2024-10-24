package com.example.inventory.domain.service.impl;

import com.example.inventory.domain.dto.ProductStock;
import com.example.inventory.infraestructure.entities.Product;
import com.example.inventory.infraestructure.repositories.ProductRepository;
import com.example.inventory.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductStock> getAllProductStocks() {
        return productRepository.getAllProducts();
    }

    @Override
    public void updateProductStock(Long productId, int stock) {
        // Obtener el producto usando Optional<Product>
        Optional<Product> optionalProduct = productRepository.findById(productId);
    
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get(); // Obtener el producto del Optional
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
