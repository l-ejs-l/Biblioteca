package common.interfaces.dao;

import common.dominios.Libro;
import common.dominios.Recurso;

/**
 * Interfaz extiende de DAO y contiene los métodos para mantener la entidad Libro
 */
public interface LibroDAO extends DAO<Libro> {

    void saveRecurso(Libro entity, Recurso recurso) throws Exception;
}
