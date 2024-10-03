package com.microservice.inventario.infraestructure.mapper;

public package com.ejemplo.inventario.infrastructure.mapper;

import com.ejemplo.inventario.domain.dto.ReorderRequestDTO;
import com.ejemplo.inventario.domain.entities.ReorderRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReorderRequestMapper {

    @Mappings({
        @Mapping(source = "productId", target = "productId"),
        @Mapping(source = "quantity", target = "quantity"),
        @Mapping(target = "requestId", ignore = true)  // Ignoramos el requestId en el DTO ya que no existe
    })
    ReorderRequestDTO toReorderRequestDTO(ReorderRequest reorderRequest);

    List<ReorderRequestDTO> toReorderRequestDTOs(List<ReorderRequest> reorderRequests);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "requestId", ignore = true)  // Se ignora al mapear de vuelta ya que no proviene del DTO
    })
    ReorderRequest toReorderRequest(ReorderRequestDTO reorderRequestDTO);
} {

}
