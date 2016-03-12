/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.neptuno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ausiasmarch.neptuno.entity.Oficina;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;

/**
 *
 * @author a048598270y
 */
public class OficinaDAO implements GenericDAO<Oficina, Long> {

    String sentencia;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = DBConnection.instance.getConnection(DriverType.MYSQL);

    @Override
    public void create(Oficina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Oficina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertOrUpdate(Oficina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Oficina findById(Long id) {
        try {
            sentencia = "SELECT idOficina,ciudad FROM oficina WHERE idOficina = ?";
            ps = con.prepareStatement(sentencia);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                return new Oficina(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OficinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Oficina> findAll() {
        List<Oficina> lista = new ArrayList<>();
        try {
            sentencia = "SELECT idOficina,ciudad FROM oficina";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Oficina(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OficinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public <K> Long newKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
