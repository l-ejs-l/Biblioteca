package test;

import common.dao.AutorDAOImpl;
import common.dominios.Autor;

import java.util.List;

public class AutorDAOTest {

    public static void main(String[] args) {

        AutorDAOImpl dao = new AutorDAOImpl();
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();
        Autor autor3 = new Autor();

        autor1.setApellido("Shiaaa");
        autor1.setNombre("Shoro");

        autor2.setApellido("Jeldes");
        autor2.setNombre("Emilio");

        autor3.setNombre("asd");
        autor3.setApellido("asd");

        try {
            dao.save(autor1);
            dao.save(autor2);
            dao.save(autor3);
            System.out.println("Autor ingresado");
            Autor autorToDelete = dao.findByName(autor3.getNombre(), autor3.getApellido());
            System.out.println("Encontrado Autor por nombre");
            Autor findById = dao.find(autorToDelete.getId());
            System.out.println("Encontrado autor por id");
            autorToDelete.setNombre("Modificado");
            dao.update(autorToDelete);
            System.out.println("Autor modificado correctamente");
            List<Autor> all = dao.findAll();
            all.forEach(System.out::println);
            dao.remove(autorToDelete.getId());
            System.out.println("Autor removido correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
