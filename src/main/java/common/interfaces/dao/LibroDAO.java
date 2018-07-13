package common.interfaces.dao;

import common.dominios.Autor;
import common.dominios.Libro;
import common.dominios.Recurso;
import common.dominios.Topico;

import java.util.List;

/**
 * Interfaz extiende de DAO y contiene los métodos para mantener la entidad Libro
 */
public interface LibroDAO extends DAO<Libro> {

    void saveRecurso(Libro entity, Recurso recurso, List<Autor> autores, List<Topico> topicos) throws Exception;
}
