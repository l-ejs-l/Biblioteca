package common.interfaces.dao;

import common.dominios.Topico;
import common.interfaces.dao.base.DAO;
import common.interfaces.dao.base.FindByEntityName;
import common.interfaces.dao.base.FindListByEntityId;

/**
 * Interfaz que extiende de DAO y FindByEntityName y, contiene los métodos para mantener la entidad Topico
 */
public interface TopicoDAO extends DAO<Topico>, FindByEntityName<Topico>, FindListByEntityId<Topico> {

}
