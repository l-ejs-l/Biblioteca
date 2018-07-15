package common.interfaces.dao.base;

/**
 * Interfaz que contiene método generico update() para realizar una modificacion en la DB de la entidad <T>
 *
 * @param <T> Entidad Generica
 */
public interface UpdateEntity<T> {
    /**
     * Este método actualiza los datos de la <T> en la base de datos
     *
     * @param entity entidad tipo <T>
     */
    void update(T entity) throws Exception;
}
