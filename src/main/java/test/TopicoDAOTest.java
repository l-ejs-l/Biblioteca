package test;

import common.dao.TopicoDAOImpl;
import common.dominios.Topico;

import java.util.List;

public class TopicoDAOTest {

    public static void main(String[] args) {

        TopicoDAOImpl dao = new TopicoDAOImpl();

        Topico topico1 = new Topico();
        topico1.setTopico("Ciencia Ficcion");

        Topico topico2 = new Topico();
        topico2.setTopico("Fantasía");

        Topico topico3 = new Topico();
        topico3.setTopico("Aventura");

        try {
            dao.save(topico1);
            dao.save(topico2);
            dao.save(topico3);

            Topico topicoToDelete = dao.findByName("Aventura");
            System.out.println("Encontre el topico aventura por nombre");
            Topico topicoToFindById = dao.find(topicoToDelete.getId());
            System.out.println("Encontre el topico aventura por id");
            topicoToDelete.setTopico("Modificado");
            dao.update(topicoToDelete);
            System.out.println("Topico modificado correctamente");
            List<Topico> all = dao.findAll();
            all.forEach(System.out::println);
            dao.remove(topicoToDelete.getId());
            System.out.println("Topico eliminado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
