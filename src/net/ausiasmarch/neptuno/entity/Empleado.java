/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.neptuno.entity;

import java.sql.Date;

/**
 *
 * @author Soy yo
 */
public class Empleado {

    private long numEmple;
    private String nombre, apellidos;
    private int idOficina, cargo;
    private Date naci, alta;

    public Empleado(long numEmple, String nombre, String apellidos, int cargo, int idOficina, Date naci, Date alta) {
        this.nombre = nombre;       //cambiar esto por el cambio en el cargo del metodo findAll
        this.apellidos = apellidos;
        this.idOficina = idOficina;
        this.cargo = cargo;
        this.numEmple = numEmple;
        this.alta = alta;
        this.naci = naci;

    }

    public Date getNaci() {
        return naci;
    }

    public void setNaci(Date naci) {
        this.naci = naci;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public long getNumEmple() {
        return numEmple;
    }

    public void setNumEmple(long numEmple) {
        this.numEmple = numEmple;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

}
