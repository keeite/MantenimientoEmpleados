/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ausiasmarch.neptuno.entity;

/**
 *
 * @author a048598270y
 */
public class Cargo {
    
    private int idCargo;
    private String descripcion;

    public Cargo(int idCargo, String descripcion) {
        this.idCargo = idCargo;
        this.descripcion = descripcion;
    }
    
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
