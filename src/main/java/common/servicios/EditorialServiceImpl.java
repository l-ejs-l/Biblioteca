package common.servicios;

import common.dao.EditorialDAOImpl;
import common.dominios.Editorial;
import common.interfaces.dao.EditorialDAO;
import common.interfaces.servicios.EditorialService;

import java.util.Optional;

/**
 * Implementa Interfaz EditorialService que contiene los métodos y logica de negocio asociada a la
 * entidad Editorial
 *
 * @author emilio
 */
public class EditorialServiceImpl implements EditorialService {

    EditorialDAO editorialDAO = new EditorialDAOImpl();

    @Override
    public boolean insertEditorial(Editorial editorial) throws Exception {
        editorialDAO.save(editorial);
        return Optional.of(editorialDAO.findByName(editorial.getEditorial())).isPresent();
    }
}
