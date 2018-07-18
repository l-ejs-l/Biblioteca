package common.interfaces.dao;

import common.dominios.Editorial;
import common.interfaces.dao.base.FindByEntityName;

/**
 * Interfaz que extiende de DAO y contiene los métodos para mantener la entidad Editorial
 * @author emilio
 */
public interface EditorialDAO extends DAO<Editorial>, FindByEntityName<Editorial> {


}
