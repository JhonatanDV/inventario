package com.example.inventory.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.infraestructure.entities.ProductStock;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "stock", target = "stock")
    ProductStockDTO toProductStockDTO(ProductStock product);

    List<ProductStockDTO> toProductStockDTOs(List<ProductStock> products);
}
