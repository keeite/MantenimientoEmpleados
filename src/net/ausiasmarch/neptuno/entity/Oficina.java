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
public class Oficina {
    private int idOficina;
    private String ciudad;
    
    public Oficina(int idOficina, String ciudad) {
        this.idOficina = idOficina;
        this.ciudad = ciudad;
    }
    
    public long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
