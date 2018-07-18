package common.interfaces.dao.base;

import java.util.Set;

/**
 * Interfaz que contiene método generico findByName() para realizar la busqueda por nombre en la DB de la entidad <T>
 *
 * @param <T> Entidad generica
 * @author emilio
 */
public interface FindListByEntityId<T> {

    /**
     * Realiza la búsqueda de entidades <T> en la DB que coincida con el parametro id especificado y retorna una List<T>
     *
     * @param id int de entidad
     * @return List<T> de entidades <T>
     * @throws Exception en caso de no encontrar entidades en la DB.
     */
    Set<T> findListById(int id) throws Exception;
}
