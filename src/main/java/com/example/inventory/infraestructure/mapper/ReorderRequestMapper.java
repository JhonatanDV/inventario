package com.example.inventory.infraestructure.mapper;

import com.example.inventory.domain.dto.ReorderRequestDTO;
import com.example.inventory.infraestructure.entities.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReorderRequestMapper {

    @Mapping(source = "stock", target = "quantity") 
    ReorderRequestDTO toReorderRequest(ProductStock product);
}
