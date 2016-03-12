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
import javax.swing.JOptionPane;
import net.ausiasmarch.neptuno.entity.Empleado;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;

/**
 *
 * @author Grupo Dani, Victor y Alejandro
 */
public class EmpleadoDAO implements GenericDAO<Empleado, Long> {

    private final Connection conn = DBConnection.instance.getConnection(DriverType.MYSQL);
    private String sentencia;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void create(Empleado t) {

        try {
            sentencia = "INSERT INTO empleado (nombre,apellidos,idCargo,fechaNa,"
                    + "fechaAlta,idOficina)"
                    + " VALUES ( ? , ? , ? , ? , ? , ? )";

            ps = conn.prepareStatement(sentencia);

            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellidos());
            ps.setInt(3, t.getIdCargo());
            ps.setDate(4, t.getAlta());
            ps.setDate(5, t.getNaci());
            ps.setInt(6, t.getIdOficina());

            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al insertar el registro");
        }

    }

    @Override
    public void update(Empleado t) {
        try {
            sentencia = "UPDATE empleado SET nombre = ?, apellidos = ?, idCargo = ?, fechaNa = ?,"
                    + "fechaAlta = ?,idOficina = ? WHERE idEmpleado = ?";

            ps = conn.prepareStatement(sentencia);

            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellidos());
            ps.setInt(4, t.getIdCargo());
            ps.setDate(5, t.getAlta());
            ps.setDate(6, t.getNaci());
            ps.setInt(7, t.getIdOficina());
            ps.setLong(9, t.getNumEmple());
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al actualizar el registro");
        }
    }

    @Override
    public void delete(Long id) {
        sentencia = "DELETE * FROM empleado WHERE idEmpleado = " + id;

        try {
            ps = conn.prepareStatement(sentencia);
            ps.execute();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al borrar el registro");
        }

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
        Empleado em;
        List<Empleado> lista = new ArrayList<>();

        sentencia = "SELECT idEmpleado,nombre,apellidos,Cargo,idOficina,fechaNa,fechaAlta FROM empleado";

        try {
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                em = new Empleado(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
                lista.add(em);
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return lista;
    }

    public EmpleadoDAO() {
    }

    @Override
    public <K> Long newKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
