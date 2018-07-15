package common.interfaces.dao.base;

/**
 * Esta interfaz generica contiene los metodos basicos de una operacion CRUD.
 *
 * @param <T> Tipo de entidad a implementar
 */

public interface DAO<T> extends FindEntityById<T>, FindAllEntities<T>, SaveEntity<T>,
    UpdateEntity<T>, RemoveEntity<T> {

}

