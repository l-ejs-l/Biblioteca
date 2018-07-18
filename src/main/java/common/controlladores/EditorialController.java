package common.controlladores;

import common.dominios.Editorial;
import common.interfaces.servicios.EditorialService;
import common.servicios.EditorialServiceImpl;
import common.validate.EditorialValidator;

/**
 * Controllador de entidad Editorial a ejecutarse desde el cliente
 *
 * @author emilio
 */
public class EditorialController {

    EditorialValidator validator = new EditorialValidator();
    EditorialService editorialService = new EditorialServiceImpl();

    /**
     * Método de ejecucion a nivel del cliente que retorna (1) true si realizó la persistencia o (2) false
     * en caso contrario, de la entidad Editorial
     *
     * @param editorial entidad
     * @return boolean
     * @throws Exception en caso de error de validación
     */
    public boolean insertEditorial(Editorial editorial) throws Exception {
        validator.validate(editorial);
        return editorialService.insertEditorial(editorial);
    }

}
