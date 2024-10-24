package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import com.example.inventory.domain.dto.StockUpdateRequest;
import com.example.inventory.infraestructure.entities.Product;

@Mapper(componentModel = "spring")
public interface StockUpdateRequestMapper {

    @Mapping(source = "stock", target = "stock")
    StockUpdateRequest toStockUpdateRequest(Product product);

    @InheritInverseConfiguration
    Product toProduct(StockUpdateRequest stockUpdateRequest);
}
