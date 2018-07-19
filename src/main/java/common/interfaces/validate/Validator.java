package common.interfaces.validate;

/**
 * Interfaz genérica que contiene método de validacion
 *
 * @param <T> Entidad generica
 * @author emilio
 */
public interface Validator<T> {

    /**
     * Método para realizar la validacion de parámetros de entidaded <T> que vienen del lado del cliente.
     *
     * @param entity generica <T>
     * @throws Exception en caso de encontrar errores.
     */
    void validate(T entity) throws Exception;

}
