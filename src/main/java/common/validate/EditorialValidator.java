package common.validate;

import common.dominios.Editorial;
import common.interfaces.validate.Validator;

/**
 * Implementa la common.validate.Validator<T> para realizar la validacion de la entidad Editorial
 *
 * @author emilio
 */
public class EditorialValidator implements Validator<Editorial> {

    @Override
    public void validate(Editorial entity) throws Exception {
        if (entity.getEditorial().equals("") || entity.getEditorial() == null) {
            throw new Exception("Debe seleccionar una editorial");
        }
    }
}
