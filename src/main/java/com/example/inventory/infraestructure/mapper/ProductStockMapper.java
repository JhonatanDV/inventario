package com.example.inventory.infraestructure.mapper;

import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.infraestructure.entities.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface ProductStockMapper {

    @Mapping(source = "lastUpdated", target = "lastUpdated", qualifiedByName = "dateToLocalDateTime")
    ProductStockDTO toProductStockDTO(ProductStock productStock);

    List<ProductStockDTO> toProductStockDTOs(List<ProductStock> productStockList);

    ProductStock toEntity(ProductStockDTO productStockDTO);

    // Método auxiliar para convertir Date a LocalDateTime
    @Named("dateToLocalDateTime")
    default LocalDateTime dateToLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
