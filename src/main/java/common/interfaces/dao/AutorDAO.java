package common.interfaces.dao;

import common.dominios.Autor;
import common.interfaces.dao.base.DAO;

/**
 * Interfaz que extiende de DAO y contiene los métodos para mantener la entidad Autor
 */
public interface AutorDAO extends DAO<Autor> {

    Autor findByName(String name, String lastName) throws Exception;
}
