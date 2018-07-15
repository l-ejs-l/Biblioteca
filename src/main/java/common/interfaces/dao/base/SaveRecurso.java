package common.interfaces.dao.base;

import common.dominios.Recurso;

public interface SaveRecurso<T> {

    /**
     * Método transaccional que realiza la persistencia de un Recurso, entidad <T>, Editorial y Autores
     *
     * @param entity  Recibe una entidad <T>
     * @param recurso Recibe un Recurso
     * @throws Exception Lanza Exepcion en caso de no poder realizar la persistencia
     */
    void saveRecurso(T entity, Recurso recurso) throws Exception;
}
