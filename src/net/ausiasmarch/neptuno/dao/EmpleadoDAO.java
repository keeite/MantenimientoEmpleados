/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.neptuno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ausiasmarch.neptuno.entity.Empleado;
import net.ausiasmarch.neptuno.model.DBConnection;

/**
 *
 * @author Grupo Dani, Victor y Alejandro
 */
public class EmpleadoDAO implements GenericDAO<Empleado, Long> {

    private final Connection conn = DBConnection.instance.getConnection();

    @Override
    public void create(Empleado t) {

        try {
            String sentencia = "INSERT INTO empleado (nombre,apellidos,ciudad,idCargo,fechaNa,"
                    + "fechaAlta,idOficina,,email)"
                    + " VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";

            PreparedStatement ps = conn.prepareStatement(sentencia);

            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellidos());
            ps.setString(3, t.getCiudad());
            ps.setInt(4, t.getIdCargo());
            ps.setDate(5, t.getAlta());
            ps.setDate(6, t.getNaci());
            ps.setInt(7, t.getIdOficina());
            ps.setString(8, t.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertOrUpdate(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <K> Long newKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
