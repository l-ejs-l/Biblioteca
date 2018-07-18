package common.controlladores;

import common.dominios.Recurso;
import common.interfaces.servicios.RecursoService;
import common.servicios.RecursoServiceImpl;
import common.validate.RecursoValidator;

/**
 * Controllador de entidad Recurso a ejecutarse desde el cliente
 *
 * @author emilio
 */
public class RecursoController {

    private final RecursoService recursoService = new RecursoServiceImpl();
    private final RecursoValidator validator = new RecursoValidator();

    /**
     * Método de ejecucion a nivel del cliente que retorna (1) true si realizo la persistencia o (2) false
     * en caso contrario
     *
     * @param recurso mapeo de la vista en entidad Recurso
     * @return boolean
     * @throws Exception en caso de encontrar errores de validacion
     */
    public boolean insertRecurso(Recurso recurso) throws Exception {
        validator.validate(recurso);
        return recursoService.insertRecurso(recurso);
    }

}
