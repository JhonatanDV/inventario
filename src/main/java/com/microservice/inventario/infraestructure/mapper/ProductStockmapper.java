package com.ejemplo.inventario.infrastructure.mapper;

import com.ejemplo.inventario.domain.dto.ProductStockDTO;
import com.ejemplo.inventario.domain.entities.ProductStock;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mappings({
        @Mapping(source = "productId", target = "productId"),
        @Mapping(source = "stock", target = "stock")
    })
    ProductStockDTO toProductStockDTO(ProductStock productStock);

    List<ProductStockDTO> toProductStockDTOs(List<ProductStock> productStocks);

    @InheritInverseConfiguration
    ProductStock toProductStock(ProductStockDTO productStockDTO);
}
