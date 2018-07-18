package common.interfaces.dao;

import common.dominios.Topico;
import common.interfaces.dao.base.FindByEntityName;
import common.interfaces.dao.base.FindListByEntityId;

/**
 * Interfaz que extiende de DAO, FindByEntityName y FindListByEntityId y, contiene los métodos
 * para mantener la entidad Topico
 *
 * @author emilio
 */
public interface TopicoDAO extends DAO<Topico>, FindByEntityName<Topico>, FindListByEntityId<Topico> {

}
