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

    private int id;
    private String ciudad;

    public Oficina(int id, String ciudad) {
        this.id = id;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

}
