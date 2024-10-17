package com.inventario.controller;

import com.inventario.model.Producto;
import com.inventario.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inventory")
public class InventarioController {

    private final ProductoRepository productoRepo = new ProductoRepository();

    // GET /inventory
    @GetMapping
    public ResponseEntity<List<StockResponse>> consultarStock() {
        try {
            List<Producto> productos = productoRepo.findAll();
            List<StockResponse> stockResponses = productos.stream()
                .map(producto -> new StockResponse(producto.getIdProducto(), producto.getCantidadEnStock()))
                .collect(Collectors.toList());
            return ResponseEntity.ok(stockResponses);
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // PUT /inventory/{productId}
    @PutMapping("/{productId}")
    public ResponseEntity<MessageResponse> actualizarStock(@PathVariable Integer productId, @RequestBody StockUpdateRequest request) {
        try {
            Producto producto = productoRepo.getById(productId);
            if (producto == null) {
                return ResponseEntity.notFound().build();
            }
            producto.setCantidadEnStock(request.getStock());
            productoRepo.save(producto);
            return ResponseEntity.ok(new MessageResponse("Stock actualizado"));
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // POST /inventory/reorder
    @PostMapping("/reorder")
    public ResponseEntity<MessageResponse> solicitarReposicion(@RequestBody ReorderRequest request) {
        try {
            // Aquí deberías implementar la lógica para manejar la reposición
            // Por simplicidad, solo devolveremos un mensaje
            return ResponseEntity.ok(new MessageResponse("Reposición solicitada"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Clases internas para las respuestas y solicitudes
    public static class StockResponse {
        private Integer productId;
        private Integer stock;

        public StockResponse(Integer productId, Integer stock) {
            this.productId = productId;
            this.stock = stock;
        }

        public Integer getProductId() {
            return productId;
        }

        public Integer getStock() {
            return stock;
        }
    }

    public static class StockUpdateRequest {
        private Integer stock;

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }
    }

    public static class ReorderRequest {
        private Integer productId;
        private Integer quantity;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }

    public static class MessageResponse {
        private String message;

        public MessageResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
