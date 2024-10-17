package com.inventario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.inventario.config.DatabaseConnection;
import com.inventario.model.Proveedor;

public class ProveedorRepository implements Repository<Proveedor> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Proveedor> findAll() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (Statement myStat = getConnection().createStatement()) {
            ResultSet myResultSet = myStat.executeQuery(sql);
            while (myResultSet.next()) {
                Proveedor proveedor = createProveedor(myResultSet);
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }

    @Override
    public Proveedor getById(Integer id) throws SQLException {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        try (PreparedStatement myStat = getConnection().prepareStatement(sql)) {
            myStat.setInt(1, id);
            try (ResultSet myRes = myStat.executeQuery()) {
                if (myRes.next()) {
                    proveedor = createProveedor(myRes);
                }
            }
        }
        return proveedor;
    }

    @Override
    public void save(Proveedor proveedor) throws SQLException {
        String sql;
        if (proveedor.getIdProveedor() != null && proveedor.getIdProveedor() > 0) {
            sql = "UPDATE proveedores SET nombre_proveedor = ?, contacto = ?, telefono = ?, direccion = ? WHERE id_proveedor = ?";
        } else {
            sql = "INSERT INTO proveedores (nombre_proveedor, contacto, telefono, direccion) VALUES