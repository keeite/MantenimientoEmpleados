package net.ausiasmarch.neptuno.model;

/**
 * Operation.java Enumerado con las operaciones posibles en una base de datos
 *
 * @author luis
 */
public enum Operation {

    NEW, EDIT, DELETE, VIEW;

    @Override
    public String toString() {

        if (this == NEW) {
            return "Nuevo registro";
        }
        if (this == EDIT) {
            return "Editar registro";
        }
        if (this == DELETE) {
            return "Borrar regitro";
        }
        return null;
    }
}
