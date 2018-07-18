package common.interfaces.dao;

import common.dominios.Autor;
import common.interfaces.dao.base.FindListByEntityId;

/**
 * Interfaz que extiende de DAO y contiene los métodos para mantener la entidad Autor
 * @author emilio
 */
public interface AutorDAO extends DAO<Autor>, FindListByEntityId<Autor> {

    Autor findByName(String name, String lastName) throws Exception;
}
