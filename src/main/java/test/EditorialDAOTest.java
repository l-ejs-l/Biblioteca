package test;

import common.dao.EditorialDAOImpl;
import common.dominios.Editorial;

public class EditorialDAOTest {

    public static void main(String[] args) {

        EditorialDAOImpl dao = new EditorialDAOImpl();
        Editorial editorial = new Editorial();
        editorial.setEditorial("Austral");

        try {
            dao.save(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



