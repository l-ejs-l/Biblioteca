package test;

import common.dao.EditorialDAOImpl;
import common.dominios.Editorial;

public class EditorialDAOTest {

    public static void main(String[] args) {

        EditorialDAOImpl dao = new EditorialDAOImpl();

        Editorial editorial1 = new Editorial();
        editorial1.setEditorial("Austral");

        Editorial editorial2 = new Editorial();
        editorial2.setEditorial("McGraw Hill");

        Editorial editorial3 = new Editorial();
        editorial3.setEditorial("asd");

        try {
            dao.save(editorial1);
            dao.save(editorial2);
            dao.save(editorial3);
            System.out.println("Editorial Insertada correctamente");
            Editorial editorialToDelete = dao.findByName("asd");
            System.out.println("Encontre la editorial por nombre");
            dao.find(editorialToDelete.getId());
            System.out.println("Encontre la editorial por id");
            editorialToDelete.setEditorial("Modificada");
            dao.update(editorialToDelete);
            System.out.println("Editorial Modificada correctamente");
            dao.findAll().forEach(System.out::println);
            dao.remove(editorialToDelete.getId());
            System.out.println("Editorial Removida Correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}



