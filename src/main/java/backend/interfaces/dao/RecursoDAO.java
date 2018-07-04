package backend.interfaces.dao;

import backend.dominios.Recurso;
import backend.dominios.enums.TipoRecurso;
import backend.dominios.enums.TipoTexto;
import java.util.Set;

/**
 * Esta interfaz extiende la interfaz DAO e implementa métodos personalizados para la mantencion de
 * la entidad Recurso
 */
public interface RecursoDAO extends DAO<Recurso> {

//    Definicion de métodos personalizados para la conexion recurso Dato ej:
    /**
     * Este método realiza una busqueda en la base de datos por entidades tipo recurso que contengan
     * el TipoRecurso especificado
     *
     * @param tipoRecurso enum tipo de recurso
     * @return un set con entidades Recurso
     */
    Set<Recurso> findByTipoRecurso(TipoRecurso tipoRecurso);

    /**
     * Este método realiza una busqueda en la base de datos por entidades tipo recurso que contengan
     * el TipoTexto especificado
     *
     * @param tipoTexto enum tipo de texto
     * @return set con entidades Recurso
     */
    Set<Recurso> findByTipoTexto(TipoTexto tipoTexto);

}
