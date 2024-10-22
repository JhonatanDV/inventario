package com.inventario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.inventario.config.DatabaseConnection;
import com.inventario.model.Producto;
import com.microservice.inventario.domain.Interfaz_repository.Product;

public class ProductoRepository implements Repository<Producto> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id_producto, nombre_producto, descripcion_producto FROM productos";
        try (Connection conn = getConnection(); 
             PreparedStatement myStat = conn.prepareStatement(sql);
             ResultSet myResultSet = myStat.executeQuery()) {
             
            while (myResultSet.next()) {
                Product product = new Product(myResultSet.getInt("id_producto"), myResultSet.getString("nombre_producto"), myResultSet.getString("descripcion_producto"));
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Producto> findAll() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = getConnection(); 
             PreparedStatement myStat = conn.prepareStatement(sql);
             ResultSet myResultSet = myStat.executeQuery()) {
             
            while (myResultSet.next()) {
                Producto producto = createProducto(myResultSet);
                productos.add(producto);
            }
        }
        return productos;
    }

    @Override
    public Producto getById(Integer id) throws SQLException {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE id_producto = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement myStat = conn.prepareStatement(sql)) {
             
            myStat.setInt(1, id);
            try (ResultSet myRes = myStat.executeQuery()) {
                if (myRes.next()) {
                    producto = createProducto(myRes);
                }
            }
        }
        return producto;
    }

    @Override
    public void save(Producto producto) throws SQLException {
        String sql = (producto.getIdProducto() != null && producto.getIdProducto() > 0) ?
            "UPDATE productos SET nombre_producto = ?, descripcion_producto = ? WHERE id_producto = ?" :
            "INSERT INTO productos (nombre_producto, descripcion_producto) VALUES (?, ?)";
        
        try (Connection conn = getConnection(); 
             PreparedStatement myStat = conn.prepareStatement(sql)) {
             
            myStat.setString(1, producto.getNombreProducto());
            myStat.setString(2, producto.getDescripcionProducto());
            if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
                myStat.setInt(3, producto.getIdProducto());
            }
            myStat.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement myStamt = conn.prepareStatement(sql)) {
             
            myStamt.setInt(1, id);
            myStamt.executeUpdate();
        }
    }

    private Producto createProducto(ResultSet myResult) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(myResult.getInt("id_producto"));
        producto.setNombreProducto(myResult.getString("nombre_producto"));
        producto.setDescripcionProducto(myResult.getString("descripcion_producto"));
        return producto;
    }
}