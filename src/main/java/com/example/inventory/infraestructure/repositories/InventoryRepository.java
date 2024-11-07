package com.example.inventory.infraestructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.inventory.infraestructure.crud_interface.InventoryCrudRepository;
import com.example.inventory.infraestructure.entities.ProductStock;
import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.domain.repository.InventoryRepositoryInterface;
import com.example.inventory.infraestructure.mapper.ProductStockMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InventoryRepository implements InventoryRepositoryInterface {

    @Autowired
    private InventoryCrudRepository inventoryCrudRepository;

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public List<ProductStockDTO> getAllInventories() {
        List<ProductStock> productStocks = (List<ProductStock>) inventoryCrudRepository.findAll();
        return productStocks.stream()
                            .map(productStockMapper::toProductStockDTO)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductStockDTO> findById(Long id) {
        return inventoryCrudRepository.findById(id)
                                      .map(productStockMapper::toProductStockDTO);
    }

    @Override
    public ProductStockDTO createInventory(ProductStockDTO productStockDTO) {
        ProductStock productStock = productStockMapper.toEntity(productStockDTO);
        ProductStock savedProductStock = inventoryCrudRepository.save(productStock);
        return productStockMapper.toProductStockDTO(savedProductStock);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryCrudRepository.deleteById(id);
    }

    @Override
    public List<ProductStockDTO> findInventoriesByProductId(Long productId) {
        List<ProductStock> productStocks = inventoryCrudRepository.findByProductId(productId);
        return productStocks.stream()
                            .map(productStockMapper::toProductStockDTO)
                            .collect(Collectors.toList());
    }
}
