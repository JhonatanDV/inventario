package com.example.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.domain.dto.ProductStockDTO;
import com.example.inventory.domain.dto.ReorderRequestDTO;
import com.example.inventory.domain.dto.StockUpdateRequestDTO;
import com.example.inventory.domain.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // GET /inventory
    @GetMapping
    public ResponseEntity<List<ProductStockDTO>> getAllProductStocks() {
        List<ProductStockDTO> productStocks = inventoryService.getAllProductStocks();
        return ResponseEntity.ok(productStocks);
    }

    // PUT /inventory/{productId}
    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProductStock(@PathVariable("productId") Long productId,
                                                     @RequestBody StockUpdateRequestDTO request) {
        inventoryService.updateProductStock(productId, request.getStock());
        return ResponseEntity.ok("{\"message\": \"Stock actualizado\"}");
    }

        @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Endpoint funcionando");
    }
    // POST /inventory/reorder
    @PostMapping("/reorder")
    public ResponseEntity<String> reorderInventory(@RequestBody ReorderRequestDTO request) {
        inventoryService.reorderInventory(request.getProductId(), request.getQuantity());
        return ResponseEntity.ok("{\"message\": \"Reposición solicitada\"}");
    }
}
