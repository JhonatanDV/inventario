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
public class ProductRepository implements InventoryRepositoryInterface {

    @Autowired
    private InventoryCrudRepository productCrudRepository;

    @Autowired
    private ProductStockMapper productStockMapper;

    @Override
    public List<ProductStockDTO> getAllInventories() {
        List<ProductStock> productStocks = (List<ProductStock>) productCrudRepository.findAll();
        return productStocks.stream()
                            .map(productStockMapper::toProductStockDTO)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductStockDTO> findById(Long id) {
        return productCrudRepository.findById(id)
                                    .map(productStockMapper::toProductStockDTO);
    }

    @Override
    public ProductStockDTO createInventory(ProductStockDTO productStockDTO) {
        ProductStock productStock = productStockMapper.toEntity(productStockDTO);
        ProductStock savedProductStock = productCrudRepository.save(productStock);
        return productStockMapper.toProductStockDTO(savedProductStock);
    }

    @Override
    public void deleteInventory(Long id) {
        productCrudRepository.deleteById(id);
    }
    @Override
public List<ProductStockDTO> findInventoriesByProductId(Long productId) {
    List<ProductStock> productStocks = productCrudRepository.findByProductId(productId);
    return productStocks.stream()
                        .map(productStockMapper::toProductStockDTO)
                        .collect(Collectors.toList());
}

    public void save(ProductStockDTO productStockDTO) {
        ProductStock productStock = productStockMapper.toEntity(productStockDTO);
        productCrudRepository.save(productStock);
    }
}
