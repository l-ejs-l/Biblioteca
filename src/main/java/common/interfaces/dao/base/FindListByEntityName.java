package common.interfaces.dao.base;

import java.util.Set;

/**
 * Interfaz que contiene método generico findByName() para realizar la busqueda por nombre en la DB de la entidad <T>
 *
 * @param <T> Entidad generica
 */
public interface FindListByEntityName<T> {

    /**
     * Realiza la búsqueda de entidades <T> en la DB que coincida con el parametro name especificado y retorna una List<T>
     *
     * @param name String nombre
     * @return List<T>, lista de entidad <T>
     * @throws Exception en caso de no encontrar entidades <T>
     */
    Set<T> findByName(String name) throws Exception;
}
