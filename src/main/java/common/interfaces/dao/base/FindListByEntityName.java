package common.interfaces.dao.base;

import java.util.List;

public interface FindListByEntityName<T> {

    /**
     * Realiza la búsqueda de entidades <T> en la DB que coincida con el parametro name especificado y retorna una List<T>
     *
     * @param name String nombre
     * @return List<T>, lista de entidad <T>
     * @throws Exception en caso de no encontrar entidades <T>
     */
    List<T> findByName(String name) throws Exception;
}
