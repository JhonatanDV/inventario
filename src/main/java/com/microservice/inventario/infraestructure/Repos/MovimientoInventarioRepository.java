package com.inventario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.inventario.config.DatabaseConnection;
import com.inventario.model.MovimientoInventario;

public class MovimientoInventarioRepository implements Repository<MovimientoInventario> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<MovimientoInventario> findAll() throws SQLException {
        List<MovimientoInventario> movimientos = new ArrayList<>();
        String sql = "SELECT * FROM movimientos_inventario";
        try (Statement myStat = getConnection().createStatement()) {
            ResultSet myResultSet = myStat.executeQuery(sql);
            while (myResultSet.next()) {
                MovimientoInventario movimiento = createMovimientoInventario(myResultSet);
                movimientos.add(movimiento);
            }
        }
        return movimientos;
    }

    @Override
    public MovimientoInventario getById(Integer id) throws SQLException {
        MovimientoInventario movimiento = null;
        String sql = "SELECT * FROM movimientos_inventario WHERE id_movimiento = ?";
        try (PreparedStatement myStat = getConnection().prepareStatement(sql)) {
            myStat.setInt(1, id);
            try (ResultSet myRes = myStat.executeQuery()) {
                if (myRes.next()) {
                    movimiento = createMovimientoInventario(myRes);
                }
            }
        }
        return movimiento;
    }

    @Override
    public void save(MovimientoInventario movimiento) throws SQLException {
        String sql;
        if (movimiento.getIdMovimiento() != null && movimiento.getIdMovimiento() > 0) {
            sql = "UPDATE movimientos_inventario SET id_producto = ?, id_proveedor = ?, tipo_movimiento = ?, cantidad = ?, descripcion = ? WHERE id_movimiento = ?";
        } else {
            sql = "INSERT INTO movimientos_inventario (id_producto, id_proveedor, tipo_movimiento, cantidad, descripcion) VALUES (?, ?, ?, ?, ?)";
        }

        try (PreparedStatement myStat = getConnection().prepareStatement(sql)) {
            myStat.setInt(1, movimiento.getIdProducto());
            myStat.setInt(2, movimiento.getIdProveedor());
            myStat.setString(3, movimiento.getTipoMovimiento().toString());
            myStat.setInt(4, movimiento.getCantidad());
            myStat.setString(5, movimiento.getDescripcion());
            if (movimiento.getIdMovimiento() != null && movimiento.getIdMovimiento() > 0) {
                myStat.setInt(6, movimiento.getIdMovimiento());
            }
            myStat.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement myStamt = getConnection().prepareStatement("DELETE FROM movimientos_inventario WHERE id_movimiento = ?")) {
            myStamt.setInt(1, id);
            myStamt.executeUpdate();
        }
    }

    private MovimientoInventario createMovimientoInventario(ResultSet myResult) throws SQLException {
        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setIdMovimiento(myResult.getInt("id_movimiento"));
        movimiento.setIdProducto(myResult.getInt("id_producto"));
        movimiento.setIdProveedor(myResult.getInt("id_proveedor"));
        movimiento.setTipoMovimiento(MovimientoInventario.TipoMovimiento.valueOf(myResult.getString("tipo_movimiento")));
        movimiento.setCantidad(myResult.getInt("cantidad"));
        movimiento.setDescripcion(myResult.getString("descripcion"));
        return movimiento;
    }
}