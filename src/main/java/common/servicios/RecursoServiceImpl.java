package common.servicios;

import common.dao.AutorDAOImpl;
import common.dao.EditorialDAOImpl;
import common.dao.RecursoDAOImpl;
import common.dao.TopicoDAOImpl;
import common.dominios.Autor;
import common.dominios.Recurso;
import common.dominios.Topico;
import common.interfaces.dao.AutorDAO;
import common.interfaces.dao.EditorialDAO;
import common.interfaces.dao.RecursoDAO;
import common.interfaces.dao.TopicoDAO;
import common.interfaces.servicios.RecursoService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Implementa Interfaz RecursoService que contiene los métodos y logica de negocio asociada a
 * la entidad Recurso
 *
 * @author emilio
 */
public class RecursoServiceImpl implements RecursoService {

    private final RecursoDAO recursoDAO = new RecursoDAOImpl();
    private final EditorialDAO editorialDAO = new EditorialDAOImpl();
    private final TopicoDAO topicoDAO = new TopicoDAOImpl();
    private final AutorDAO autorDAO = new AutorDAOImpl();

    @Override
    public boolean insertRecurso(Recurso recurso) throws Exception {
        recurso.setEditorial(editorialDAO.findByName(recurso.getEditorial().getEditorial()));
        Set<Topico> topicosSaved = new HashSet<>();
        for (Topico topico : (Set<Topico>) recurso.getTopicos()) {
            topicosSaved.add(topicoDAO.findByName(topico.getTopico()));
        }
        recurso.setTopicos(topicosSaved);

        Set<Autor> autoresSaved = new HashSet<>();
        for (Autor autor : (Set<Autor>) recurso.getAutores()) {
            autoresSaved.add(autorDAO.findByName(autor.getNombre(), autor.getApellido()));
        }
        recurso.setAutores(autoresSaved);

        recursoDAO.save(recurso);

        if (Optional.of(recursoDAO.findByName(recurso.getTitulo())).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
