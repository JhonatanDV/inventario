package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import com.example.inventory.domain.dto.ProductStockDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "stock", target = "stock")
    ProductStockDTO toProductStock(ProductStockDTO product);

    List<ProductStockDTO> toProductStocks(List<ProductStockDTO> products);

    @InheritInverseConfiguration
    ProductStockDTO toProduct(ProductStockDTO productStock);
}
