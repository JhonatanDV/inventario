package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.inventory.domain.dto.ReorderRequestDTO;
import com.example.inventory.infraestructure.entities.ProductStock;

@Mapper(componentModel = "spring")
public interface ReorderRequestMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "stock", target = "quantity")  // Cambiar 'stock' por 'quantity'
    ReorderRequestDTO toReorderRequest(ProductStock product);
}