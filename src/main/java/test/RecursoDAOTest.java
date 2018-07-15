package test;

import common.dao.*;
import common.dominios.*;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;

import java.sql.Date;
import java.util.ArrayList;

public class RecursoDAOTest {

    public static void main(String[] args) {

        RecursoDAOImpl recursoDAO = new RecursoDAOImpl();
        EditorialDAOImpl editorialDAO = new EditorialDAOImpl();
        TopicoDAOImpl topicoDAO = new TopicoDAOImpl();
        AutorDAOImpl autorDAO = new AutorDAOImpl();

        Recurso<Libro> recurso1 = new Recurso<>();
        Recurso<Revista> recurso2 = new Recurso<>();
        Recurso<Periodico> recurso3 = new Recurso<>();
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Topico> topicos = new ArrayList<>();
        Autor autor = new Autor();

        autor.setApellido("Shiaaa");
        autor.setNombre("Shoro");
        autor.setId(1);
        autores.add(autor);

        Libro libro = new Libro();
        libro.setIsbn("12345785");

        Revista revista = new Revista();

        Periodico periodico = new Periodico();
        periodico.setLema("Diario el sur");
        periodico.setFechaPublicacion(Date.valueOf("1990-9-27"));

        try {
            topicos.add(topicoDAO.findByName("Fantasía"));
            topicos.add(topicoDAO.findByName("Ciencia Ficcion"));
            autores.add(autorDAO.findByName("Shoro", "Shiaaa"));

            Editorial editorial = editorialDAO.findByName("Austral");
            recurso1.setEditorial(editorial);
            recurso2.setEditorial(editorial);
            recurso3.setEditorial(editorial);
            recurso1.setTopicos(topicos);
            recurso1.setAutores(autores);
            recurso2.setTopicos(topicos);
            recurso2.setAutores(autores);
            recurso3.setTopicos(topicos);
            recurso3.setAutores(autores);


            // recurso 1 LIBRO
            recurso1.setTipoRecurso(TipoRecurso.LIBRO);
            recurso1.setTipoTexto(TipoTexto.NORMAL);
            recurso1.setTitulo("El señor de los anillos");
            recurso1.setTotalPaginas(450);
            recurso1.setRecurso(libro);
            recursoDAO.save(recurso1);

            // recurso2 Revista
            recurso2.setTipoRecurso(TipoRecurso.REVISTA);
            recurso2.setTipoTexto(TipoTexto.NORMAL);
            recurso2.setTitulo("Titulo revista");
            recurso2.setTotalPaginas(50);
            recurso2.setRecurso(revista);
            recursoDAO.save(recurso2);

            // recurso3 Periodico
            recurso3.setTipoRecurso(TipoRecurso.PERIODICO);
            recurso3.setTipoTexto(TipoTexto.ALTA_DEMANDA);
            recurso3.setTitulo("Titulo periodico");
            recurso3.setTotalPaginas(30);
            recurso3.setRecurso(periodico);
            recursoDAO.save(recurso3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
