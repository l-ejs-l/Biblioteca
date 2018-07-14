package common.interfaces.dao;

import common.dominios.Topico;
import common.interfaces.dao.base.DAO;
import common.interfaces.dao.base.FindByNameDAO;

/**
 * Interfaz que extiende de DAO y FindByNameDAO y, contiene los métodos para mantener la entidad Topico
 */
public interface TopicoDAO extends DAO<Topico>, FindByNameDAO<Topico> {

}
