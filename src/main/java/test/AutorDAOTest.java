package test;

import common.dao.AutorDAOImpl;
import common.dominios.Autor;

public class AutorDAOTest {

    public static void main(String[] args) {

        AutorDAOImpl dao = new AutorDAOImpl();
        Autor autor = new Autor();
        autor.setApellido("Shiaaa");
        autor.setNombre("Shoro");

        try {
            dao.save(autor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
