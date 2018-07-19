package common.interfaces.dao;


import common.dominios.Factura;
import common.interfaces.dao.DAO;

/**
 * Interfaz extiende de DAO y contiene declaracion de metodos para mantener entidad Cuenta
 */
public interface FacturaDAO extends DAO<Factura> {

    public boolean isValidLogin(Factura factura) throws Exception;

    public boolean isCuentaTaken(Factura factura);

    public void save(Factura factura);

}
