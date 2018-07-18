package common.validate;


import common.dominios.*;
import common.interfaces.validate.Validator;

import java.util.Set;

/**
 * Implementa la common.validate.Validator<T> para realizar la validacion de la entidad Recurso
 *
 * @author emilio
 */
public class RecursoValidator implements Validator<Recurso> {

    EditorialValidator editorialValidator = new EditorialValidator();
    AutorValidator autorValidator = new AutorValidator();
    TopicoValidator topicoValidator = new TopicoValidator();

    @Override
    public void validate(Recurso entity) throws Exception {
        // Titulo Recurso
        if (entity.getTitulo().equals("") || entity.getTitulo().length() < 3) {
            throw new Exception("Debe ingresar un título válido");
        }
        // Tipo de Recurso
        if (entity.getTipoRecurso().equals("")) {
            throw new Exception("Debe seleccionar un Tipo de recurso");
        }

        // Valida Recurso Libro | Periodico | Revista
        switch (entity.getTipoRecurso()) {
            case LIBRO:
                Libro libro = (Libro) entity.getRecurso();
                if (libro.getIsbn().equals("") || libro.getIsbn().length() < 7) {
                    throw new Exception("Isbn debe contener al menos 7 caracteres numéricos");
                }
                try {
                    Integer.parseInt(libro.getIsbn());
                } catch (NumberFormatException e) {
                    throw new Exception("Isbn solo debe contener numeros");
                }
                break;
            case PERIODICO:
                Periodico periodico = (Periodico) entity.getRecurso();
                if (periodico.getFechaPublicacion() == null) {
                    throw new Exception("Fecha de publicacion no puede ser vacia");
                }
                if (periodico.getLema().length() < 3 || periodico.getLema().equals("")) {
                    throw new Exception("Debe ingresar un lema válido");
                }
                break;

            case REVISTA:
                break;
        }

        if (entity.getTotalPaginas() < 0 || entity.getTotalPaginas() > 2500) {
            throw new Exception("Debe insertar un total de páginas válido");
        }

        if (entity.getTipoTexto().equals("")) {
            throw new Exception("Debe seleccionar un tipo de texto");
        }

        editorialValidator.validate(entity.getEditorial());
        Set<Topico> topicos = entity.getTopicos();
        for (Topico topico : topicos) {
            topicoValidator.validate(topico);
        }
        Set<Autor> autors = entity.getAutores();
        for (Autor autor : autors) {
            autorValidator.validate(autor);
        }
    }
}
