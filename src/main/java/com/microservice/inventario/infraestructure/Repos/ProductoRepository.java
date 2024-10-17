package com.inventario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.inventario.config.DatabaseConnection;
import com.inventario.model.Producto;

public class ProductoRepository implements Repository<Producto> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }
    private CrudProducto productoCrud;

    @Override
    public List<Producto> findAll() throws SQLException {
       
       productoCrud.findAll()
    }

    @Override
    public Producto getById(Integer id) throws SQLException {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE id_producto = ?";
        try (PreparedStatement myStat = getConnection().prepareStatement(sql)) {
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
        String sql;
        if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
            sql = "UPDATE productos SET nombre_producto = ?, descripcion = ?, precio = ?, cantidad_en_stock = ? WHERE id_producto = ?";
        } else {
            sql = "INSERT INTO productos (nombre_producto, descripcion, precio, cantidad_en_stock) VALUES (?, ?, ?, ?)";
        }

        try (PreparedStatement myStat = getConnection().prepareStatement(sql)) {
            myStat.setString(1, producto.getNombreProducto());
            myStat.setString(2, producto.getDescripcion());
            myStat.setDecimal(3, producto.getPrecio());
            myStat.setInt(4, producto.getCantidadEnStock());
            if (producto.getIdProducto() != null && producto.getIdProducto() > 0) {
                myStat.setInt(5, producto.getIdProducto());
            }
            myStat.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement myStamt = getConnection().prepareStatement("DELETE FROM productos WHERE id_producto = ?")) {
            myStamt.setInt(1, id);
            myStamt.executeUpdate();
        }
    }

    private Producto createProducto(ResultSet myResult) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(myResult.getInt("id_producto"));
        producto.setNombreProducto(myResult.getString("nombre_producto"));
        producto.setDescripcion(myResult.getString("descripcion"));
        producto.setPrecio(myResult.getBigDecimal("precio"));
        producto.setCantidadEnStock(myResult.getInt("cantidad_en_stock"));
        return producto;
    }
}