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
public class Empleado {
    private long numEmple;
    private String nombre,apellidos,ciudad,email,naci,alta;
    private int idCargo,idOficina;
    

    public Empleado(long numEmple,String nombre,String apellidos,String ciudad,String email,int idCargo,int idOficina,String naci, String alta){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.email = email;
        this.idOficina = idOficina;
        this.idCargo = idCargo;
        this.numEmple = numEmple;
        this.alta = alta;
        this.naci = naci;
        
    }

    public String getNaci() {
        return naci;
    }

    public void setNaci(String naci) {
        this.naci = naci;
    }

    public String getAlta() {
        return alta;
    }

    public void setAlta(String alta) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
