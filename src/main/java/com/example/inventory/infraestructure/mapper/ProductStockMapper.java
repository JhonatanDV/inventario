package com.example.inventory.infraestructure.mapper;

import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.infraestructure.entities.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mapping(source = "lastUpdated", target = "lastUpdated")  
    ProductStockDTO toProductStockDTO(ProductStock productStock);

    List<ProductStockDTO> toProductStockDTOs(List<ProductStock> productStockList);

    ProductStock toEntity(ProductStockDTO productStockDTO);
}

