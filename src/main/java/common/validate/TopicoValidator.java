package common.validate;

import common.dominios.Topico;
import common.interfaces.validate.Validator;

/**
 * Implementa la common.validate.Validator<T> para realizar la validacion de la entidad Topico
 *
 * @author emilio
 */
public class TopicoValidator implements Validator<Topico> {

    @Override
    public void validate(Topico entity) throws Exception {

        if (entity.getTopico().equals("") || entity.getTopico() == null) {
            throw new Exception("Debe insertar un tipico");
        }
    }
}
