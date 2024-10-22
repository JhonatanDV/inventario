package com.inventario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.inventario.config.DatabaseConnection;
import com.inventario.model.Proveedor;
import com.microservice.inventario.domain.Interfaz_repository.Supplier;

public class ProveedorRepository implements Repository<Proveedor> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    public List<Supplier> getSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT id_proveedor, nombre_proveedor, descripcion_proveedor FROM proveedores";
        try (Connection conn = getConnection(); 
             PreparedStatement myStat = conn.prepareStatement(sql);
             ResultSet myResultSet = myStat.executeQuery()) {
             
            while (myResultSet.next()) {
                Supplier supplier = new Supplier(myResultSet.getInt("id_proveedor"), myResultSet.getString("nombre_proveedor"), myResultSet.getString("descripcion_proveedor"));
                suppliers.add(supplier);
            }
        }
        return suppliers;
    }

    @Override
    public List<Proveedor> findAll() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (Connection conn = getConnection(); 
             PreparedStatement myStat = conn.prepareStatement(sql);
             ResultSet myResultSet = my