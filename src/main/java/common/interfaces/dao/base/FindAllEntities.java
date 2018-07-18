package common.interfaces.dao.base;

import java.util.Set;

/**
 * Interfaz que contiene método generico findAll() para realizar una busqueda en la DB de la entidad <T>
 *
 * @param <T> Entidad Generica
 * @author emilio
 */
public interface FindAllEntities<T> {

    /**
     * Este método busca todas las entidades del tipo <T> en la base de datos y las devuelve en una lista
     *
     * @return lista de con todas las entidades en cuestion
     */
    Set<T> findAll() throws Exception;
}
