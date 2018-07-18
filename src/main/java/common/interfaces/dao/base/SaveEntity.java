package common.interfaces.dao.base;

/**
 * Interfaz que contiene método generico save() para realizar la persistencia en la DB de la entidad <T>
 *
 * @param <T> Entidad Generica
 * @author emilio
 */
public interface SaveEntity<T> {

    /**
     * Este método guarda la entidad <T> en la base de datos
     *
     * @param entity entidad tipo <T>
     */
    void save(T entity) throws Exception;
}
