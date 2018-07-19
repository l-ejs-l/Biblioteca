package common.interfaces.dao;

import common.dominios.Recurso;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import common.interfaces.dao.base.FindListByEntityName;

import java.util.Set;

/**
 * Interfaz que extiende de DAO y contiene los métodos para mantener la entidad Recurso
 * @author emilio
 */
public interface RecursoDAO extends DAO<Recurso>, FindListByEntityName<Recurso> {

    /**
     * Realiza la busqueda en la DB de entidades Recurso con el TipoRecurso especificado
     *
     * @param tipoRecurso enum TipoRecurso
     * @return Set<Recurso> resultado de busqueda
     * @throws Exception en caso de no encontrar por TipoRecurso
     */
    Set<Recurso> findByTipoRecurso(TipoRecurso tipoRecurso) throws Exception;

    /**
     * Realiza la busqueda en la DB de entidades Recurso con el TipoTexto especificado
     *
     * @param tipoTexto enum TipoTexto
     * @return Set<Recurso> resultado de busqueda
     * @throws Exception en caso de no encontrar por TipoTexto
     */
    Set<Recurso> findByTipoTexto(TipoTexto tipoTexto) throws Exception;


}
