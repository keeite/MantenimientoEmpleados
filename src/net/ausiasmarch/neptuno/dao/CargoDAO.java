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
import net.ausiasmarch.neptuno.entity.Cargo;
import net.ausiasmarch.neptuno.entity.Empleado;
import net.ausiasmarch.neptuno.entity.Oficina;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;

/**
 *
 * @author a048598270y
 */
public class CargoDAO implements GenericDAO<Cargo, Long> {

    private final Connection conn = DBConnection.instance.getConnection(DriverType.ACCESS);
    private String sentencia;
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void create(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertOrUpdate(Cargo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargo findById(Long id) {
        try {
            
            sentencia = "SELECT idCargo, descripcion FROM cargo WHERE idCargo = " + id;
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            rs.next();
            
            return new Cargo(rs.getInt(1), rs.getString(2));
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Cargo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <K> Long newKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
