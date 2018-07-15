package common.interfaces.dao.base;

/**
 * Interfaz que contiene método generico remove() para eliminar de la DB la entidad <T>
 *
 * @param <T> Entidad Generica
 */
public interface RemoveEntity<T> {

    /**
     * Este método elimina la entidad en cuestion de la base de datos
     *
     * @param id clave primaria de la entidad
     */
    void remove(int id) throws Exception;
}
