package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import com.example.inventory.domain.dto.ReorderRequest;
import com.example.inventory.infraestructure.entities.Product;

@Mapper(componentModel = "spring")
public interface ReorderRequestMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "stock", target = "quantity")  // Cambiar 'stock' por 'quantity'
    ReorderRequest toReorderRequest(Product product);

    @InheritInverseConfiguration
    Product toProduct(ReorderRequest reorderRequest);
}