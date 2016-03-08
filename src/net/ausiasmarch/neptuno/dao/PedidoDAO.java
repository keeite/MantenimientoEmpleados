/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.neptuno.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;

/**
 *
 * @author Dani
 */
public class PedidoDAO implements GenericDAO {

    StringBuilder sentencia = new StringBuilder();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = DBConnection.instance.getConnection(DriverType.MYSQL);

    @Override
    public void create(Object t) {

    }

    @Override
    public void update(Object t) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void insertOrUpdate(Object t) {

    }

    @Override
    public List<List> findById(Serializable id) {
        List<List> lista = new ArrayList<>();
        List datos;
        sentencia.delete(0, sentencia.length());
        sentencia.append("SELECT d.idProducto,p.nombreProd,p.cantidadUnidad,d.precioE,d.cantidad,")
                .append("SUM(d.cantidad * d.precioE) FROM detalle_pedido d,producto p ")
                .append("WHERE p.idProducto = d.idProducto AND d.idPedido = ? GROUP BY D.IDPRODUCTO ;");

        try {

            ps = con.prepareStatement(sentencia.toString());
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();

            while (rs.next()) {
                datos = new ArrayList<>();
                for (int i = 1; i <= 6; i++) {
                    datos.add(rs.getObject(i));
                }
                lista.add(datos);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(sentencia.toString());
        }

        return lista;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Long newKey() {
        return null;
    }

    public List<Integer> allPed(long id) {
        List pedidos = new ArrayList<>();
        sentencia.delete(0, sentencia.length());
        sentencia.append("SELECT idPedido FROM pedido WHERE idEmpleado = ? ");

        try {

            ps = con.prepareStatement(sentencia.toString());

            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                pedidos.add(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;

    }
}
