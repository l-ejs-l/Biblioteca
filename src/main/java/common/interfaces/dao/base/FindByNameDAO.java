package common.interfaces.dao.base;

/**
 * Interfaz genérica que contiene método findByName() - buscarPorNombre
 *
 * @param <T> Tipo de entidad a implementar
 */
public interface FindByNameDAO<T> {

    /**
     * Realiza la busquda en la DB de una entidade <T> con el nombre especificado
     *
     * @param name String nombre
     * @return <T> resultado de la busqueda
     * @throws Exception en caso de no encontrar entidad <T>
     */
    T findByName(String name) throws Exception;

}
