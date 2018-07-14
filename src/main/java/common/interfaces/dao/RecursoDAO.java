package common.interfaces.dao;

import common.dominios.Recurso;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import common.interfaces.dao.base.DAO;

import java.util.Set;

/**
 * Interfaz que extiende de DAO y contiene los métodos para mantener la entidad Recurso
 */
public interface RecursoDAO extends DAO<Recurso> {

    /**
     * Realiza la busqueda en la DB de entidades Recurso con el TipoRecurso especificado
     *
     * @param tipoRecurso enum TipoRecurso
     * @return Set<Recurso> resultado de busqueda
     */
    Set<Recurso> findByTipoRecurso(TipoRecurso tipoRecurso);

    /**
     * Realiza la busqueda en la DB por de entidades Recurso con el TipoTexto especificado
     *
     * @param tipoTexto enum TipoTexto
     * @return Set<Recurso> resultado de busqueda
     */
    Set<Recurso> findByTipoTexto(TipoTexto tipoTexto);

}
