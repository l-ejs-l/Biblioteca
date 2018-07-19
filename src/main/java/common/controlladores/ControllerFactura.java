package common.controlladores;

import common.dao.FacturaDAOImpl;
import common.dominios.Factura;
import common.interfaces.dao.FacturaDAO;

import java.sql.SQLException;

public class ControllerFactura {

    private FacturaDAO db = (FacturaDAO) new FacturaDAOImpl();

    public ControllerFactura() {

    }


    public boolean isExistingAccount(Factura factura) throws Exception {
        boolean w = db.isCuentaTaken(factura);
        System.out.println("isExistingAccount =" + w);
        return w;
    }

    public boolean isValidLogin(Factura factura) throws Exception {
        boolean w = db.isValidLogin(factura);
        System.out.println("isValidLogin =" + w);
        return w;

    }

    public void addAccount(Factura factura) {
        try {
            db.save(factura);
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
