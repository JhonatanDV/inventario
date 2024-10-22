package com.microservice.inventario.domain.Interfaz_repository;

import java.util.List;

// Definición de la respuesta para el endpoint GET /inventory
class InventoryItem {
    private int productId;
    private int stock;

    // Constructor
    public InventoryItem(int productId, int stock) {
        this.productId = productId;
        this.stock = stock;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }
}

class GetInventoryResponse {
    private List<InventoryItem> items;

    // Constructor
    public GetInventoryResponse(List<InventoryItem> items) {
        this.items = items;
    }

    // Getter
    public List<InventoryItem> getItems() {
        return items;
    }
}

// Definición de la solicitud y respuesta para el endpoint PUT /inventory/{productId}
class UpdateStockRequest {
    private int stock;

    // Constructor
    public UpdateStockRequest(int stock) {
        this.stock = stock;
    }

    // Getter
    public int getStock() {
        return stock;
    }
}

class UpdateStockResponse {
    private String message;

    // Constructor
    public UpdateStockResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }
}

// Definición de la solicitud y respuesta para el endpoint POST /inventory/reorder
class ReorderRequest {
    private int productId;
    private int quantity;

    // Constructor
    public ReorderRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

class ReorderResponse {
    private String message;

    // Constructor
    public ReorderResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }
}