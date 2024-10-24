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
    private ProductStockMapper productMapper;

    public List<ProductStock> getAllProducts() {
        List<ProductStock> products = (List<ProductStock>) productCrudRepository.findAll();
        return productMapper.toProductStocks(products);
    }

    // Cambiar aquí para retornar Optional<Product>
    public Optional<ProductStock> findById(Long id) {
        return productCrudRepository.findById(id); // Aquí ya estás usando Optional en el crud
    }

    public ProductStock save(ProductStock product) {
        ProductStock savedProduct = productCrudRepository.save(product);
        return productMapper.toProductStock(savedProduct);
    }

    public void deleteById(Long id) {
        productCrudRepository.deleteById(id);
    }
}
