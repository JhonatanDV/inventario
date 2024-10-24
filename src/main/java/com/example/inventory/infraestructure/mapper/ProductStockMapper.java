package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import com.example.inventory.domain.dto.ProductStock;
import com.example.inventory.infraestructure.entities.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "stock", target = "stock")
    ProductStock toProductStock(Product product);

    List<ProductStock> toProductStocks(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct(ProductStock productStock);
}
