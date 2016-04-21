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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.ausiasmarch.common.Convert;
import net.ausiasmarch.neptuno.entity.Cargo;
import net.ausiasmarch.neptuno.entity.Empleado;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;

/**
 *
 * @author Grupo Dani, Victor y Alejandro
 */
public class EmpleadoDAO implements GenericDAO<Empleado, Long> {

    private final Connection conn = DBConnection.instance.getConnection(DriverType.ACCESS);
    private String sentencia;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void create(Empleado t) {
        try {
            CargoDAO cargoDAO = new CargoDAO();
            Cargo cargo = cargoDAO.findById((long)t.getCargo()); 
            
            sentencia = "INSERT INTO empleado (idEmpleado,nombre,apellidos,idCargo,fechaNa,"
                    + "fechaAlta,idOficina)"
                    + " VALUES ( ? , ? , ? , ? , ? , ? , ? )";

            ps = conn.prepareStatement(sentencia);
            
            ps.setLong(1, t.getNumEmple());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellidos());
            ps.setLong(4, t.getCargo());
            ps.setDate(5, t.getNaci());
            ps.setDate(6, t.getAlta());
            ps.setInt(7, t.getIdOficina());
            ps.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al insertar el registro");
        }

    }

    @Override
    public void update(Empleado t) {
        try {
            sentencia = "UPDATE empleado SET nombre = ?, apellidos = ?, ciudad = ?, idCargo = ?, fechaNa = ?,"
                    + "fechaAlta = ?,idOficina = ? WHERE idEmpleado = ?";

            ps = conn.prepareStatement(sentencia);

            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellidos());
//            ps.setString(3, t.getCiudad());
            ps.setLong(4, t.getCargo());
            ps.setDate(5, t.getAlta());
            ps.setDate(6, t.getNaci());
            ps.setInt(7, t.getIdOficina());
            ps.setLong(8, t.getNumEmple());
            ps.execute();
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

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al borrar el registro");
        }

    }

    @Override
    public void insertOrUpdate(Empleado t) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM empleado ")
        .append("WHERE nombre = ? AND apellidos = ? AND fechaNa = ? AND fechaAlta = ?");
        
        try {
            ps = conn.prepareStatement(sb.toString());
            
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellidos());
            ps.setDate(3, t.getNaci());
            ps.setDate(4, t.getAlta());
            
            rs = ps.executeQuery();
            
            if (rs.getLong(1) != 0) {
                JOptionPane.showMessageDialog(null, "El registro introducido ya existe");
            } else {
                create(t);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al crear el registro");
        }
        
        
    }

    @Override
    public Empleado findById(Long id) {
        Empleado em = null;
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT idEmpleado, nombre, apellidos, idCargo, idOficina, fechaNa, fechaAlta ").
            append("FROM empleado WHERE idEmpleado = ?");
        
        try {
            ps = conn.prepareStatement(sql.toString());
            ps.setLong(1, id);
            rs = ps.executeQuery();
            
            rs.next();
                em = new Empleado(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return em;
    }

    @Override
    public List<Empleado> findAll() {
        Empleado em;
        List<Empleado> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        
        //sentencia = "SELECT idEmpleado,nombre,apellidos,ciudad,cargo,idOficina,fechaNa,fechaAlta FROM empleado";
        sql.append("SELECT idEmpleado, nombre, apellidos, idCargo, idOficina, fechaNa, fechaAlta ").
            append("FROM empleado ");
        
        try {
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                em = new Empleado(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
                lista.add(em);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return lista;
    }

    public EmpleadoDAO() {
    }

    @Override
    public <K> Long newKey() {
        
        long key = 0;
        
        try {
            
            sentencia = "SELECT MAX(idEmpleado) FROM empleado";
            
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
                 
            key = rs.next() ? rs.getLong(1) + 1: null;
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return key;
    }
    
    public List<String> cargo() {
        
        List<String> lista = new ArrayList();
        
        try {
            
            sentencia = "SELECT descripcion FROM cargo ORDER BY idcargo";
            
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public List<Integer> idOficina() {
        
        List<Integer> lista = new ArrayList();
        
        try {
            
            sentencia = "SELECT DISTINCT idOficina FROM oficina ORDER BY idOficina";
            
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
        
    }
    
    public long countAll() {
        try {
            
            sentencia = "SELECT COUNT(*) FROM empleado";
            
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            
            rs.next();
            
            return rs.getLong(1);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    /*
    Método de busqueda
    */
    public List<List> busquedaEmpleados(List param) {
        StringBuilder sql = new StringBuilder();
        List newParam = new ArrayList();
        List<List> listaEmpleados = new ArrayList();
        List listaDatos;

        PreparedStatement ps;
        ResultSet rs;
        int cols;

        sql.append("SELECT e.idEmpleado, CONCAT(e.nombre, ' ' ,e.apellidos) AS nombre, o.ciudad, c.descripcion, o.idOficina, e.fechaNa, e.fechaAlta ").
            append("FROM oficina o, empleado e, cargo c ").
            append("WHERE e.idOficina = o.idOficina AND e.idCargo = c.idCargo");

        if (param.size() > 6) {
            throw new RuntimeException("Número de parámetros incorrecto");
        }
        if (!param.get(0).equals("")) {
            sql.append(" AND UCASE(e.nombre) = ?");
            newParam.add(param.get(0));
        }
        if (!param.get(1).equals("")) {
            sql.append(" AND e.idEmpleado = ?");
            newParam.add(param.get(1));
        }
        if (!param.get(2).equals("--Seleccionar--")) {
            sql.append(" AND c.descripcion = ?");
            newParam.add(param.get(2));
        }
        if (!param.get(3).equals("")) {
            sql.append(" AND e.fechaAlta = ?");
            Date fechaAlta = Convert.parseDate(param.get(3).toString());
            java.sql.Date altaSql = new java.sql.Date(fechaAlta.getTime());
            newParam.add(altaSql);
        }
        if (!param.get(4).equals("")) {
            sql.append(" AND e.fechaNa = ?");
            Date fechaNaci = Convert.parseDate(param.get(4).toString());
            java.sql.Date naciSql = new java.sql.Date(fechaNaci.getTime());
            newParam.add(naciSql);
        }
        if (!param.get(5).equals("--Seleccionar--")) {
            sql.append(" AND e.idOficina = ?");
            newParam.add(param.get(5));
        }

        sql.append(" ORDER BY 2");

        try {

            ps = conn.prepareStatement(sql.toString());

            for (int i = 0; i < newParam.size(); i++) {
                ps.setObject(i + 1, newParam.get(i));
            }

            rs = ps.executeQuery();
            cols = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                listaDatos = new ArrayList<>();
                for (int i = 1; i <= cols; i++) {
                    listaDatos.add(rs.getObject(i));
                }
                listaEmpleados.add(listaDatos);
            }

            return listaEmpleados;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
