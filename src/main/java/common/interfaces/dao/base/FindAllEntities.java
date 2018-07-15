package common.interfaces.dao.base;

import java.util.List;

/**
 * Interfaz que contiene método generico findAll() para realizar una busqueda en la DB de la entidad <T>
 *
 * @param <T> Entidad Generica
 */
public interface FindAllEntities<T> {

    /**
     * Este método busca todas las entidades del tipo <T> en la base de datos y las devuelve en una lista
     *
     * @return lista de con todas las entidades en cuestion
     */
    List<T> findAll() throws Exception;
}
