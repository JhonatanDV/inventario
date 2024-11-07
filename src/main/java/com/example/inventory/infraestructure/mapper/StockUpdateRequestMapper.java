package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.inventory.domain.dto.StockUpdateRequestDTO;
import com.example.inventory.infraestructure.entities.ProductStock;

@Mapper(componentModel = "spring")
public interface StockUpdateRequestMapper {

    @Mapping(source = "stock", target = "stock")
    StockUpdateRequestDTO toStockUpdateRequest(ProductStock product);
}
