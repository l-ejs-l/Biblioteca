package common.validate;

import common.dominios.Autor;
import common.interfaces.validate.Validator;

/**
 * Implementa la common.validate.Validator<T> para realizar la validacion de la entidad Autor
 *
 * @author emilio
 */
public class AutorValidator implements Validator<Autor> {

    @Override
    public void validate(Autor entity) throws Exception {

        if (entity.getNombre().equals("") || entity.getNombre() == null) {
            throw new Exception("Debe añadir un Autor");
        }

        if (entity.getApellido().equals("") || entity.getApellido() == null) {
            throw new Exception("Debe añadir un Autor");
        }
    }
}
