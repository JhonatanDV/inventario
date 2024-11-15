package com.example.inventory.domain.service.impl;

import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.infraestructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductStockDTO> getAllProductStocks() {
        return productRepository.getAllInventories();
    }

    public ProductStockDTO getProductById(Long productId) {
        Optional<ProductStockDTO> product = productRepository.findById(productId);
        return product.orElse(null); // Si el producto no existe, retorna null
    }

    public void updateProductStock(Long productId, int stock) {
        Optional<ProductStockDTO> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            ProductStockDTO product = optionalProduct.get();
            product.setStock(stock);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public String reorderInventory(Long productId, int quantity) {
        Optional<ProductStockDTO> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            ProductStockDTO product = optionalProduct.get();
            int newStock = product.getStock() + quantity;
            product.setStock(newStock);

            productRepository.save(product);

            return String.format("{\"message\": \"Reposición solicitada para el producto '%s'. Stock actualizado a %d\"}",
                    product.getproductname(), newStock);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}

