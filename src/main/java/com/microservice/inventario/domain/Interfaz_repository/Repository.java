package com.inventario.service;

import com.inventario.model.MovimientoInventario;
import com.inventario.model.Producto;
import com.inventario.model.Proveedor;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository {

    // Métodos para Productos
    List<Producto> obtenerTodosLosProductos() throws SQLException;
    Producto obtenerProductoPorId(Integer id) throws SQLException;
    void guardarProducto(Producto producto) throws SQLException;
    void eliminarProducto(Integer id) throws SQLException;

    // Métodos para Proveedores
    List<Proveedor> obtenerTodosLosProveedores() throws SQLException;
    Proveedor obtenerProveedorPorId(Integer id) throws SQLException;
    void guardarProveedor(Proveedor proveedor) throws SQLException;
    void eliminarProveedor(Integer id) throws SQLException;

    // Métodos para Movimientos de Inventario
    List<MovimientoInventario> obtenerTodosLosMovimientos() throws SQLException;
    MovimientoInventario obtenerMovimientoPorId(Integer id) throws SQLException;
    void guardarMovimientoInventario(MovimientoInventario movimiento) throws SQLException;
    void eliminarMovimientoInventario(Integer id) throws SQLException;
}
