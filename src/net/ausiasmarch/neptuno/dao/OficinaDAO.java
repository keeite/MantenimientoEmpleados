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
import java.util.List;
import net.ausiasmarch.neptuno.entity.Oficina;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;



/**
 *
 * @author a048598270y
 */
public class OficinaDAO implements GenericDAO<Oficina, Long> {
    private final Connection conn = DBConnection.instance.getConnection(DriverType.ACCESS);
    private String sentencia;
    private PreparedStatement ps;
    private ResultSet rs;

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
            sentencia = "SELECT idOficina, ciudad FROM oficina WHERE idOficina = " + id;
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            rs.next();
            return new Oficina(rs.getInt(1), rs.getString(2));
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Oficina> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <K> Long newKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
