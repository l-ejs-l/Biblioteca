package common.interfaces.dao;

import common.dominios.Libro;
import common.dominios.Recurso;
import common.interfaces.dao.base.DAO;

/**
 * Interfaz que extiende de DAO y contiene los métodos para mantener la entidad Libro
 */
public interface LibroDAO extends DAO<Libro> {

    /**
     * Método transaccional que realiza la persistencia de un Recurso<T>, entidad <T>, Editorial y Autores
     *
     * @param entity  Recibe una entidad Libro | Periodico | Revista
     * @param recurso Recibe un Recurso<T>
     * @throws Exception Lanza Exepcion en caso de no poder realizar la persistencia
     */
    void saveRecurso(Libro entity, Recurso recurso) throws Exception;
}
