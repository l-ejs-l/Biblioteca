package test;

import common.dao.EditorialDAOImpl;
import common.dao.LibroDAOImpl;
import common.dao.TopicoDAOImpl;
import common.dominios.Autor;
import common.dominios.Libro;
import common.dominios.Recurso;
import common.dominios.Topico;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOTest {

    public static void main(String[] args) {

        LibroDAOImpl dao = new LibroDAOImpl();
        EditorialDAOImpl editorialDAO = new EditorialDAOImpl();
        TopicoDAOImpl topicoDAO = new TopicoDAOImpl();

        Recurso<Libro> recurso = new Recurso<>();
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Topico> topicos = new ArrayList<>();
        Autor autor = new Autor();

        autor.setApellido("Shiaaa");
        autor.setNombre("Shoro");
        autor.setId(1);
        autores.add(autor);

        Libro libro = new Libro();
        libro.setIsbn("12345785");


        try {
            topicos.add(topicoDAO.findByName("Fantasía"));
            topicos.add(topicoDAO.findByName("Ciencia Ficcion"));
            recurso.setTopicos(topicos);
            recurso.setAutores(autores);
            recurso.setEditorial(editorialDAO.findByName("Austral"));
            recurso.setTipoRecurso(TipoRecurso.LIBRO);
            recurso.setTipoTexto(TipoTexto.NORMAL);
            recurso.setTitulo("El señor de los anillos");
            recurso.setTotalPaginas(450);
            recurso.setRecurso(libro);
            dao.saveRecurso(libro, recurso);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
