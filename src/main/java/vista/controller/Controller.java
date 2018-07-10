package vista.controller;

import common.dao.CuentaDAOImpl;
import common.dominios.Cuenta;
import common.interfaces.dao.CuentaDAO;

import java.sql.SQLException;

public class Controller {

    private CuentaDAO db = new CuentaDAOImpl();

    public Controller() {

    }


    public boolean isExistingAccount(Cuenta cuenta) throws Exception {
        boolean w = db.isCuentaTaken(cuenta);
        System.out.println("isExistingAccount =" + w);
        return w;
    }

    public boolean isValidLogin(Cuenta cuenta) throws Exception {
        boolean w = db.isValidLogin(cuenta);
        System.out.println("isValidLogin =" + w);
        return w;

    }

    public void addAccount(Cuenta cuenta) {
        try {
            db.save(cuenta);
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
