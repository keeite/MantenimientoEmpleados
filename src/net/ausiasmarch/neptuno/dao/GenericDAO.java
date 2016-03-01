package net.ausiasmarch.neptuno.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Esta interface contiene metodos CRUD comunes para una tabla de BD
 *
 * @author Luis
 * @param <T> Clase correspondiente una tabla de BD
 * @param <K> Clase de tipo Long (se corresponde con la primary key de la tabla)
 */
public interface GenericDAO<T, K extends Serializable> {

    /**
     * Agrega o inserta la entidad especificada.
     *
     * @param t la entidad a insertar.
     */
    public void create(T t);

    /**
     * Actualiza la entidad especificada.
     *
     * @param t la entidad a actualizar.
     */
    public void update(T t);

    /**
     * Elimina la instancia de la entidad con el id especificado.
     *
     * @param id el id de la entidad a borrar.
     */
    public void delete(K id);

    /**
     * Inserta o Actualiza la entidad especificada
     *
     * @param t La entidad a insertar/actualizar
     */
    public void insertOrUpdate(T t);

    /**
     * Obtiene una entidad a partir del id
     *
     * @param id
     * @return Una entidad
     */
    public T findById(K id);

    /**
     * Obtiene una lista de entidades
     *
     * @return
     */
    public List<T> findAll();

    /**
     * Genera un nuevo id
     *
     * @param <K>
     * @return
     */
    public <K> Long newKey();
}
