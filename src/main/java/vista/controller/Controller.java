package vista.controller;

import common.dao.UsuarioDAOImpl;
import common.dominios.Usuario;
import common.interfaces.dao.UsuarioDAO;

import java.sql.SQLException;

public class Controller {

    private UsuarioDAO db = new UsuarioDAOImpl();

    public Controller() {

    }


    public boolean isExistingAccount(Usuario cuenta) throws Exception {
        boolean w = db.isCuentaTaken(cuenta);
        System.out.println("isExistingAccount =" + w);
        return w;
    }

    public boolean isValidLogin(Usuario cuenta) throws Exception {
        boolean w = db.isValidLogin(cuenta);
        System.out.println("isValidLogin =" + w);
        return w;

    }


    public void addAccount(Usuario cuenta) {
        try {
            db.save(cuenta);
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
