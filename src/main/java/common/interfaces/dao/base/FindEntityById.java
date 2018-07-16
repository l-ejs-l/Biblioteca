package common.interfaces.dao.base;

/**
 * Interfaz que contiene método generico findListById() para realizar la busqueda por id en la DB de la entidad <T>
 *
 * @param <T> Entidad generica
 */
public interface FindEntityById<T> {

    /**
     * Este método Busca una entidad en la base de datos a través de su clave primaria
     *
     * @param id clave primaria de la entidad
     * @return la entidad en cuestion
     */
    T findById(int id) throws Exception;
}
