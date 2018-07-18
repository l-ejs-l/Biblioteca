package common.interfaces.servicios;

import common.dominios.Recurso;

/**
 * Interfaz que contiene métodos de negocio de la entidad Recurso
 * @author emilio
 */
public interface RecursoService {

    boolean insertRecurso(Recurso recurso) throws Exception;

}
