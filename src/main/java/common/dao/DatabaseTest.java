package common.dao;

import common.dominios.FreeUsuario;

public class DatabaseTest {

    public static void main(String[] args) {

        UsuarioDAOImpl cuentaDAO = new UsuarioDAOImpl();

        String username = "user1";
        String password = "pass1";
        String firstName = "Susan";
        String lastName = "Jaicks";
        String email = "ak12ka@hotmail.com";

        FreeUsuario fa = new FreeUsuario(username, password, firstName, lastName, email);
        FreeUsuario fa1 = new FreeUsuario("user2", "pass2", "David", "Natta", "1u3u32@hotmail.com");
        FreeUsuario fa2 = new FreeUsuario("user3", "pass3", "Mark", "Jue", "dfads@hotmail.com");
        try {

            //db.addFreeAccount(fa);
            cuentaDAO.save(fa);
            cuentaDAO.save(fa1);
            cuentaDAO.save(fa2);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
