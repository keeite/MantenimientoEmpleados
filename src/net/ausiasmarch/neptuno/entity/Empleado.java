/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.neptuno.entity;

import java.sql.Date;

/**
 *
 * @author a048598270y
 */
public class Empleado {

    private long numEmple;
    private String nombre, apellidos, ciudad, nombreOficina;
    private int idCargo, idOficina;
    private Date naci, alta;

    /**
     *
     * @param numEmple
     * @param nombre
     * @param apellidos
     * @param ciudad
     * @param idCargo
     * @param idOficina
     * @param naci
     * @param alta
     */
    public Empleado(long numEmple, String nombre, String apellidos, String ciudad, int idCargo, int idOficina, Date naci, Date alta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.idOficina = idOficina;
        this.idCargo = idCargo;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

}
